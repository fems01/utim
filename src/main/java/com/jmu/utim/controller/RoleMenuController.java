package com.jmu.utim.controller;

import com.jmu.utim.common.R;
import com.jmu.utim.entity.RoleMenu;
import com.jmu.utim.service.RoleMenuService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lrui1
 * @description
 * @date: 2023/6/12
 */
@CrossOrigin
@RestController
@RequestMapping("/roleMenus")
@RequiresRoles("role_superman")
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 新增菜单项与角色绑定关系
     * @param roleMenu： id、roleId、MenuId 为必须
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody RoleMenu roleMenu){
        roleMenuService.save(roleMenu);
        return R.success("添加成功！！！");
    }

    /**
     * 更新菜单项与角色绑定关系
     * @param roleMenu： id、roleId、MenuId 为必须
     * @return
     */
    @PutMapping
    public R<String> updateById(@RequestBody RoleMenu roleMenu){
        roleMenuService.updateById(roleMenu);
        return R.success("更新成功");
    }

    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable Long id) {
        roleMenuService.removeById(id);
        return R.success("删除成功");
    }
}
