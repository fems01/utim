package com.jmu.utim.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jmu.utim.entity.Role;
import com.jmu.utim.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据用户名查询对应的角色CODE
     */
    String GET_ROLE_SQL = "select r.`code` from user u JOIN role r on u.role_id=r.id " +
            "${ew.customSqlSegment}";
    @Select(GET_ROLE_SQL)
    String getRoleByName(@Param(Constants.WRAPPER) QueryWrapper<User> wrapper);
}
