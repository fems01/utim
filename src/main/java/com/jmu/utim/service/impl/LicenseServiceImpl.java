package com.jmu.utim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmu.utim.entity.License;
import com.jmu.utim.mapper.LicenseMapper;
import com.jmu.utim.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LicenseServiceImpl extends ServiceImpl<LicenseMapper, License> implements LicenseService {
    @Autowired
    private LicenseMapper licenseMapper;
    @Override
    public Set<String> getPermissionsByName(String username) {
        return licenseMapper.getPermissionsByName(username);
    }
}
