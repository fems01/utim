package com.jmu.utim.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jmu.utim.common.R;
import com.jmu.utim.entity.User;
import com.jmu.utim.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/1")
    public R<String> sendMessage(){
        return R.error("短信发送失败");
    }



    @PostMapping
    public R<String> login(@RequestBody Map map){
        String username = map.get("username").toString();

        String password = map.get("password").toString();

        LambdaQueryWrapper<User>  queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(User::getUsername,username);

        queryWrapper.eq(User::getPassword,password);

        User one = userService.getOne(queryWrapper);

        if(one!=null){
            redisTemplate.opsForValue().set(username,1,5, TimeUnit.MINUTES);
            return R.success("success");
        }
        return R.error("error");
    }



}
