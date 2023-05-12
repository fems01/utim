package com.jmu.utim;

import com.jmu.utim.entity.Role;
import com.jmu.utim.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: lrui1
 * @description Role表的测试类
 * @date: 2023/5/11
 */
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void test() {
        List<Role> list = roleService.list();
        System.out.println(list);
    }
}
