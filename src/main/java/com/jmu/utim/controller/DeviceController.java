package com.jmu.utim.controller;


import com.jmu.utim.common.R;
import com.jmu.utim.entity.Device;
import com.jmu.utim.service.DeviceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequiresPermissions("device:select")
    @GetMapping
    public R<List<Device>> getAll(){
        List<Device> list = deviceService.list();
        return R.success(list);
    }

    @RequiresPermissions("device:select:id")
    @GetMapping("/{id}")
    public R<Device> getById(@PathVariable Long id) {
        Device ret = deviceService.getById(id);
        return R.success(ret);
    }

    @RequiresPermissions("device:add")
    @PostMapping
    public R<String> save(@RequestBody Device dev) {
        deviceService.save(dev);
        return R.success("添加成功！！！");
    }
    @RequiresPermissions("device:update")
    @PutMapping
    public R<String> update(@RequestBody Device dev) {
        deviceService.updateById(dev);
        return R.success("更新成功");
    }

    @RequiresPermissions("device:delete")
    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable Long id) {
        deviceService.removeById(id);
        return R.success("删除成功");
    }

    @DeleteMapping("/init")
    public R<String> initData() {
//        deviceService.remove(null);
//        List<Device> list = new ArrayList<>();
//        list.add(new Device(1L, "admin", "管理员"));
//        deviceService.saveBatch(list);
        return R.success("初始化成功！！！");
    }

    @PutMapping("/status/{status}")
    public R<String> noShutdown(@RequestBody List<Long> ids, @PathVariable Integer status) {
        Device dev = new Device();
        dev.setStatus(status);
        for(Long id : ids) {
            dev.setId(id);
            deviceService.updateById(dev);
        }
        return R.success("ok！！！");
    }
}