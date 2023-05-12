package com.jmu.utim;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jmu.utim.entity.License;
import com.jmu.utim.service.LicenseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lrui1
 * @description
 * @date: 2023/5/11
 */
@SpringBootTest
public class LicenseServiceTest {
    @Autowired
    private LicenseService lic;

    @Test
    void logicDelete() {
        lic.removeById(1L);
    }

    @Test
    void testInit() {
        List<License> list = new ArrayList<>();
        list.add(new License(1L, "admin", "管理员"));
        lic.saveBatch(list);
    }

    @Test
    void deleteAll() {
        lic.remove(null);
    }
}
