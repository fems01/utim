package com.jmu.utim;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.jmu.utim.mapper")
@EnableTransactionManagement
@EnableCaching //添加缓存启动注解
public class UtimApplication {
    public static void main(String[] args) {
        SpringApplication.run(UtimApplication.class, args);
    }
}
