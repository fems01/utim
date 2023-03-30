package com.jmu.utim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmu.utim.dao.LicenseMapper;
import com.jmu.utim.dao.UserMapper;
import com.jmu.utim.pojo.License;
import com.jmu.utim.pojo.User;
import com.jmu.utim.service.LicenseService;
import com.jmu.utim.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class LicenseServiceImpl extends ServiceImpl<LicenseMapper, License> implements LicenseService {
}
