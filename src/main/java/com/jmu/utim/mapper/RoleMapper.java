package com.jmu.utim.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmu.utim.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
