package com.jmu.utim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmu.utim.entity.Device;
import com.jmu.utim.mapper.DeviceMapper;
import com.jmu.utim.service.DeviceService;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

}
