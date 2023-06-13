package com.jmu.utim;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: lrui1
 * @description
 * @date: 2023/6/12
 */
public class CodeTest {
    public static void main(String[] args) {
        String s = "1,2,3";
        String[] split = s.split(",");
        for(String s1 : split) {
            System.out.println(s1);
        }
    }
}
