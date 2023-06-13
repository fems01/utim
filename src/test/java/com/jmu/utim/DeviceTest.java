package com.jmu.utim;

import com.jmu.utim.entity.Device;
import com.jmu.utim.mapper.DeviceMapper;
import com.jmu.utim.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: lrui1
 * @description
 * @date: 2023/6/3
 */
@SpringBootTest
public class DeviceTest {
    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceService deviceService;

//    @Test
//    public void testAdd() {
//        Device device = new Device();
//        device.setFactoryId(1L);
//        device.setTotalCheck(100L);
//        device.setTotalBad(10L);
//        device.setBadPercent(0.1);
//        device.setDevStatus(1);
//        deviceMapper.insert(device);
//    }

    @Test
    public void getAll() {
        List<Device> list = deviceService.list();
        System.out.println(list);
    }

    @Test
    public void TestTest() {
        System.out.println("test");
    }
}
