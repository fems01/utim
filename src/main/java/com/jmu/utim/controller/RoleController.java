package com.jmu.utim.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jmu.utim.common.R;
import com.jmu.utim.entity.Role;
import com.jmu.utim.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/1")
    public R<List<Role>> getAll(){
        List<Role> list = new ArrayList<>();

        list = roleService.list();


        return R.success(list);
    }


    @PostMapping
    public R<String> save(@RequestBody Role role){

        roleService.save(role);

        return R.success("添加成功！！！");
    }

    @PutMapping
    public R<String> update(@RequestBody Role role){
        roleService.updateById(role);

        return R.success("更新成功");
    }

    /**
     * 批量处理角色状态
     * @param status
     * @param ids  存放需要操作的所有id，id间利用","分割
     * @return
     */
    @PostMapping("/status/{status}")
    public R<String> updateStatus(@PathVariable Integer status, String ids){
        String[] split = ids.split(",");

        Role role = new Role();

        role.setOpenStatus(status);

        for (String id : split) {
            LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();

            queryWrapper.eq(Role::getId,id);

            roleService.update(role,queryWrapper);


        }
        return R.success("ok ! !");

    }
}
