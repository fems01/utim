package com.jmu.utim.controller;


import com.jmu.utim.common.R;
import com.jmu.utim.entity.Device;
import com.jmu.utim.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    @GetMapping("/1")
    public R<List<Device>> getAll(){
        List<Device> list = deviceService.list();

        return R.success(list);

    }
}
