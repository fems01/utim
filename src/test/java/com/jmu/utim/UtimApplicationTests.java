package com.jmu.utim;

import com.jmu.utim.entity.Role;
import com.jmu.utim.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UtimApplicationTests {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void testRoleAdd() {
        Role role = new Role();
        role.setRoleName("13");
        role.setOpenStatus(1);
        role.setDescription("asd");
        System.out.println(roleMapper.insert(role));
    }

    @Test
    void testRoleSelect() {
        Role role = roleMapper.selectById(1L);
        System.out.println(role);
    }

    @Test
    void testRoleDelete() {
        int i = roleMapper.deleteById(1L);
        System.out.println(i);
    }
}
