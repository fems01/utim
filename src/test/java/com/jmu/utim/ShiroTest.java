package com.jmu.utim;

import com.jmu.utim.service.LicenseService;
import com.jmu.utim.service.RoleService;
import com.jmu.utim.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

/**
 * @author: lrui1
 * @description
 * @date: 2023/6/11
 */
@SpringBootTest
public class ShiroTest {
    @Autowired
    private RoleService roleService;
    @Autowired
    private LicenseService licenseService;
    @Autowired
    private UserService userService;

    @Test
    void testGetRole() {
        System.out.println("h1");
        String role = roleService.getRolesByName("张三");
        System.out.println(role);
    }

    @Test
    void testGetPermissions() {
        Set<String> list = licenseService.getPermissionsByName("张三");
        System.out.println(list);
    }
}
