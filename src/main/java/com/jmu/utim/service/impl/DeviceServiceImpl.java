package com.jmu.utim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmu.utim.dao.DeviceMapper;
import com.jmu.utim.dao.UserMapper;
import com.jmu.utim.pojo.Device;
import com.jmu.utim.pojo.User;
import com.jmu.utim.service.DeviceService;
import com.jmu.utim.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
}
