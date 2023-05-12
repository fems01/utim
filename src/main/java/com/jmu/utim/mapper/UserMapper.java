package com.jmu.utim.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmu.utim.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
