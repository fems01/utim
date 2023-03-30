package com.jmu.utim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmu.utim.dao.UserMapper;
import com.jmu.utim.pojo.User;
import com.jmu.utim.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
