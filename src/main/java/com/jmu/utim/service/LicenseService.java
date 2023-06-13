package com.jmu.utim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jmu.utim.entity.License;

import java.util.Set;

public interface LicenseService extends IService<License> {
    Set<String> getPermissionsByName(String username);
}
