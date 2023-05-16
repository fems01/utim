package com.jmu.utim;

import com.jmu.utim.common.BaseContext;
import com.jmu.utim.entity.Role;
import com.jmu.utim.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

@SpringBootTest
class UtimApplicationTests {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void testRoleAdd() {
        BaseContext.setCurrentId(1L);
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
        try
        {
            Socket s = new Socket("192.168.2.142", 10096);
            try
            {
                InputStream inStream = s.getInputStream();
                Scanner in = new Scanner(inStream);

                while (in.hasNextLine())
                {
                    String line = in.nextLine();
                    System.out.println(line);
                }
            }
            finally
            {
                s.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }




}
