package com.jmu.utim.controller;

import com.jmu.utim.common.R;
import com.jmu.utim.entity.License;
import com.jmu.utim.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/licenses")
public class LicenseController {
    @Autowired
    private LicenseService licenseService;

    @GetMapping("/1")
    private R<List<License>> getAll(){

        List<License> list = licenseService.list();

        return R.success(list);
    }

}
