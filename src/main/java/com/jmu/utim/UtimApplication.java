package com.jmu.utim;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.jmu.utim.mapper")
@EnableTransactionManagement
@EnableCaching //添加缓存启动注解
@EnableAspectJAutoProxy //开启注解格式AOP功能
public class UtimApplication {
    public static void main(String[] args) {
        SpringApplication.run(UtimApplication.class, args);
    }
}

/*
*
* lic
* id ---
* l1
*
* lic-role
* lic_id role_id --
* lic_id role_id --
* l1  r1
* l1  r2
* l2  r2
* l2  r3
*
* */
