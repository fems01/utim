package com.jmu.utim.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmu.utim.common.MenuVo;
import com.jmu.utim.entity.Menu;

import com.jmu.utim.entity.RoleMenu;
import com.jmu.utim.entity.User;
import com.jmu.utim.mapper.MenuMapper;
import com.jmu.utim.service.MenuService;
import com.jmu.utim.service.RoleMenuService;
import com.jmu.utim.service.RoleService;
import com.jmu.utim.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author: lrui1
 * @description
 * @date: 2023/6/12
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public List<Menu> getMenus(String username) {
        User user = userService.getUserInfoByName(username);
        // 查询直接拥有的菜单ID
        LambdaQueryWrapper<RoleMenu> lqw = new LambdaQueryWrapper<>();
        lqw.eq(RoleMenu::getRoleId, user.getRoleId());
        List<RoleMenu> roleMenus = roleMenuService.list(lqw);
        List<Long> menuIds = new ArrayList<>();
        for(RoleMenu r : roleMenus) {
            menuIds.add(r.getMenuId());
        }
        // 查询直接拥有的菜单列表
        LambdaQueryWrapper<Menu> lqw2 = new LambdaQueryWrapper<>();
        lqw2.in(Menu::getId, menuIds);
        List<Menu> menus = menuMapper.selectList(lqw2);
        // 将父菜单ID一起加入
        Set<Long> allMenuIds = new HashSet<>();
        for(Menu menu : menus) {
            allMenuIds.add(menu.getId());
            if(menu.getPath() == null || "".equals(menu.getPath())) {
                continue;
            }
            String[] pathIds = menu.getPath().split(",");
            for(String s : pathIds) {
                allMenuIds.add(Long.valueOf(s));
            }
        }
        // 直接返回, 转换成视图通过AOP实现
        lqw2.clear();
        lqw2.in(Menu::getId, allMenuIds);
        return menuMapper.selectList(lqw2);
//        return transform(menus, 0L);
    }

//    @Override
//    public List<MenuVo> getAllMenu() {
//        List<Menu> menus = menuMapper.selectList(null);
//        return transform(menus, 0L);
//    }


//    private List<MenuVo> transform(List<Menu> allMenu, Long parentId) {
//        List<MenuVo> resultList = new ArrayList<>();
//        if(allMenu == null) {
//            return null;
//        }
//        for(Menu menu : allMenu) {
//            if(parentId.equals(menu.getParentId())) {
//                MenuVo menuVo = new MenuVo();
//                BeanUtils.copyProperties(menu, menuVo);
//                //递归查询子菜单，并封装信息
//                List<MenuVo> childList = transform(allMenu, menu.getId());
//                menuVo.setChildMenu(childList);
//                resultList.add(menuVo);
//            }
//        }
//        return resultList;
//    }
}
