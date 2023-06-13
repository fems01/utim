package com.jmu.utim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jmu.utim.entity.Role;

public interface RoleService extends IService<Role> {

    /**
     * 根据用户名查找对应的角色
     * @param username 用户名
     * @return 角色名
     */
    String getRolesByName(String username);
}
