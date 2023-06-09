package com.jmu.utim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jmu.utim.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User> {


    public User getUserInfoByName(String name);
}

