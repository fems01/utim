package com.jmu.utim.controller;

import com.jmu.utim.common.R;
import com.jmu.utim.entity.License;
import com.jmu.utim.service.LicenseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lrui1 and fems01
 */
@CrossOrigin
@RestController
@RequestMapping("/licenses")
@RequiresRoles("role_superman")
@RequiresPermissions("lic")
public class LicenseController {
    @Autowired
    private LicenseService licenseService;

    @GetMapping
    public R<List<License>> getAll(){
        List<License> list = licenseService.list();
        return R.success(list);
    }

    @GetMapping("/{id}")
    public R<License> getById(@PathVariable Long id) {
        License ret = licenseService.getById(id);
        return R.success(ret);
    }

    @PostMapping
    public R<String> save(@RequestBody License lic) {
        licenseService.save(lic);
        return R.success("添加成功！！！");
    }

    @PutMapping
    public R<String> update(@RequestBody License lic) {
        licenseService.updateById(lic);
        return R.success("更新成功");
    }

    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable Long id) {
        licenseService.removeById(id);
        return R.success("删除成功");
    }

    @DeleteMapping("/init")
    public R<String> initData() {
        licenseService.remove(null);
        List<License> list = new ArrayList<>();
        list.add(new License(1L, "admin", "管理员"));
        licenseService.saveBatch(list);
        return R.success("初始化成功！！！");
    }

//    @PutMapping("/status/{status}")
//    public R<String> noShutdown(@RequestBody List<Long> ids, @PathVariable Integer status) {
//        // 获取系统中对应id的lic
//        List<License> list = licenseService.listByIds(ids);
//        // 将对应lic置为对应状态
//        for(License lic : list) {
//            lic.setOpenStatus(status);
//        }
//        // 修改系统中的openStatus
//        licenseService.updateBatchById(list);
//        return R.success("ok！！！");
//    }

    @PutMapping("/status/{status}")
    public R<String> noShutdown(@RequestBody List<Long> ids, @PathVariable Integer status) {
        License lic = new License();
        lic.setOpenStatus(status);
        for(Long id : ids) {
            lic.setId(id);
            licenseService.updateById(lic);
        }
        return R.success("ok！！！");
    }
}
