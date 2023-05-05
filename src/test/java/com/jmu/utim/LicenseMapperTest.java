package com.jmu.utim;


import com.jmu.utim.entity.License;
import com.jmu.utim.mapper.LicenseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LicenseMapperTest {
    @Autowired
    private LicenseMapper licenseMapper;

    @Test
    void testGetById() {
        License license = licenseMapper.selectById(1L);
        System.out.println(license);
    }

    @Test
    void testAdd() {
        License license = new License();
        license.setName("删除");
        license.setDescription("删除角色");
        licenseMapper.insert(license);
    }
}
