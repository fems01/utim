package com.jmu.utim.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jmu.utim.common.MenuVo;
import com.jmu.utim.common.R;
import com.jmu.utim.entity.Menu;
import com.jmu.utim.entity.RoleMenu;
import com.jmu.utim.entity.User;
import com.jmu.utim.service.MenuService;
import com.jmu.utim.service.RoleMenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: lrui1
 * @description 菜单控制器
 * @date: 2023/6/12
 */
@CrossOrigin
@RestController
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleMenuService roleMenuService;

    @GetMapping
    public R<List<MenuVo>> getMenus() {
        // 获取当前用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Object menus = menuService.getMenus(user.getUsername());
        return R.success((List<MenuVo>) menus);
    }

    /**
     * CRUD
     */
    @RequiresRoles("role_superman")
    @GetMapping("/all")
    public R<List<MenuVo>> getAll(){
        Object res = menuService.list();
        return R.success((List<MenuVo>) res);
    }

    @RequiresRoles("role_superman")
    @GetMapping("/{id}")
    public R<Menu> getById(@PathVariable Long id) {
        Menu menu = menuService.getById(id);
        return R.success(menu);
    }

    /**
     * 新增菜单项
     * @param menu name、code、parentId、nodeType 为必须属性
     * @return
     */
    @RequiresRoles("role_superman")
    @PostMapping
    public R<String> save(@RequestBody Menu menu){
        writePath(menu);
        menuService.save(menu);
        return R.success("添加成功！！！");
    }

    /**
     * 更新菜单项信息
     * @param menu id、为必须
     * @return
     */
    @RequiresRoles("role_superman")
    @PutMapping
    public R<String> updateById(@RequestBody Menu menu){
        if(menu.getParentId() != null) {
            writePath(menu);
        }
        menuService.updateById(menu);
        return R.success("更新成功");
    }

    @RequiresRoles("role_superman")
    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable Long id) {
        // todo 删除子目录 -- 待优化

        //删除关系表中的相关记录
        LambdaQueryWrapper<RoleMenu> lqw = new LambdaQueryWrapper<>();
        lqw.eq(RoleMenu::getMenuId, id);
        roleMenuService.remove(lqw);
        return R.success("删除成功");
    }

    private void writePath(Menu menu) {
        // 获取父菜单信息, 写入path
        Menu par = menuService.getById(menu.getParentId());
        if(par == null) {
            // 加进来的是根节点

        } else if(par.getParentId() == 0) {
            // 父菜单是跟节点
            menu.setPath(par.getId() + "," + menu.getId());
        } else {
            menu.setPath(par.getPath() + "," + menu.getId());
        }
    }
}
