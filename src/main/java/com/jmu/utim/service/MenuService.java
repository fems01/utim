package com.jmu.utim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jmu.utim.common.MenuVo;
import com.jmu.utim.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lrui1
 * @description
 * @date: 2023/6/12
 */
@Service
public interface MenuService extends IService<Menu> {
    /**
     * 根据用户名获取菜单
     * @param username 用户名
     * @return 菜单视图列表
     */
    List<Menu> getMenus(String username);

    /**
     * 查询所有菜单信息
     */
//    List<MenuVo> getAllMenu();

}
