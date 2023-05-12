package com.jmu.utim;


import com.jmu.utim.entity.License;
import com.jmu.utim.mapper.LicenseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LicenseMapperTest {
    @Autowired
    private LicenseMapper licenseMapper;

    @Test
    void testGetAll() {
        List<License> list = licenseMapper.selectList(null);
        System.out.println(list);
    }

    @Test
    void testGetById() {
        License license = licenseMapper.selectById(1L);
        System.out.println(license);
    }

    @Test
    void testAdd() {
        License license = new License();
        license.setLicName("删除");
        license.setDescription("删除角色");
        licenseMapper.insert(license);
    }

    @Test
    void logicDelete() {
        licenseMapper.deleteById(1L);
    }

    @Test
    void testFill() {
        License lic = new License();
        lic.setId(2L);
        lic.setLicName("dada");
        lic.setDescription("dada");
        licenseMapper.insert(lic);
    }

    @Test
    void testDeleteAll() {

    }

    @Test
    void testInit() {

    }
}
