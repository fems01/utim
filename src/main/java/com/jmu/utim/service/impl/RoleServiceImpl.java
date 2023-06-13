package com.jmu.utim.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmu.utim.entity.Role;
import com.jmu.utim.entity.User;
import com.jmu.utim.mapper.RoleMapper;
import com.jmu.utim.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public String getRolesByName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u.username", username);
        return roleMapper.getRoleByName(queryWrapper);
    }
}
