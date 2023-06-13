package com.jmu.utim.controller;

import com.jmu.utim.common.R;
import com.jmu.utim.entity.RoleLicContact;
import com.jmu.utim.service.RoleLicContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lrui1
 * @description 角色与权限绑定关系控制器‘
 * @date: 2023/6/13
 */
@CrossOrigin
@RestController
@RequestMapping("/roleLic")
public class RoleLicContactController {
    @Autowired
    private RoleLicContactService roleLicContactService;

    /**
     * 新增角色与权限关系
     * @param roleLicContact roleId licId 为必须
     * @return 统一结果类
     */
    @PostMapping
    public R<String> save(@RequestBody RoleLicContact roleLicContact) {
        roleLicContactService.save(roleLicContact);
        return R.success("添加成功！！！");
    }

    /**
     * 修改
     * @param roleLicContact id 为必须
     * @return 统一结果类
     */
    @PutMapping
    public R<String> update(@RequestBody RoleLicContact roleLicContact) {
        roleLicContactService.updateById(roleLicContact);
        return R.success("更新成功");
    }

    @DeleteMapping("/{id}")
    public R<String> delete(@PathVariable Long id) {
        roleLicContactService.removeById(id);
        return R.success("删除成功");
    }
}
