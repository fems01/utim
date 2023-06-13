package com.jmu.utim;

import com.jmu.utim.common.MenuVo;
import com.jmu.utim.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: lrui1
 * @description
 * @date: 2023/6/12
 */
@SpringBootTest
public class MenuTest {
    @Autowired
    private MenuService menuService;

    @Test
    void test1() {
        Object menus = menuService.getMenus("张三");
        for(MenuVo menuVo : (List<MenuVo>)menus) {
            System.out.println(menuVo);
        }
    }
}
