package com.jmu.utim.controller;


import com.jmu.utim.common.R;
import com.jmu.utim.entity.Role;
import com.jmu.utim.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {



    @Autowired
    private RoleService roleService;

    @GetMapping
    public R<List<Role>> getAll(){
        List<Role> list = roleService.list();
        return R.success(list);
    }

    @GetMapping("/{id}")
    public R<Role> getById(@PathVariable Long id) {
        Role role = roleService.getById(id);
        return R.success(role);
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

    @DeleteMapping("/{id}")
    public R<String> deleteLogicById(@PathVariable Long id) {
        roleService.removeById(id);
        return R.success("删除成功");
    }

    @DeleteMapping("/init")
    public R<String> initData() {
        roleService.remove(null);
        List<Role> list = new ArrayList<>();
        list.add(new Role(1L, "admin", "管理员"));
        roleService.saveBatch(list);
        return R.success("初始化成功！！！");
    }

    @PutMapping("/status/{status}")
    public R<String> noShutdown(@RequestBody List<Long> ids, @PathVariable Integer status) {
        Role role = new Role();
        role.setOpenStatus(status);
        for(Long id : ids) {
            role.setId(id);
            roleService.updateById(role);
        }
        return R.success("ok！！！");
    }


















//    @Autowired
//    private RoleService roleService;
//
//    @GetMapping("/1")
//    public R<List<Role>> getAll(){
//        List<Role> list = new ArrayList<>();
//
//        list = roleService.list();
//
//
//        return R.success(list);
//    }
//
//
//    @PostMapping
//    public R<String> save(@RequestBody Role role){
//
//        roleService.save(role);
//
//        return R.success("添加成功！！！");
//    }
//
//    @PutMapping
//    public R<String> update(@RequestBody Role role){
//        roleService.updateById(role);
//
//        return R.success("更新成功");
//    }
//
//    /**
//     * 批量处理角色状态
//     * @param status
//     * @param ids  存放需要操作的所有id，id间利用","分割
//     * @return
//     */
//    @PostMapping("/status/{status}")
//    public R<String> updateStatus(@PathVariable Integer status, String ids){
//        String[] split = ids.split(",");
//
//        Role role = new Role();
//
//        role.setOpenStatus(status);
//
//        for (String id : split) {
//            LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
//
//            queryWrapper.eq(Role::getId,id);
//
//            roleService.update(role,queryWrapper);
//
//
//        }
//        return R.success("ok ! !");
//
//    }
}
