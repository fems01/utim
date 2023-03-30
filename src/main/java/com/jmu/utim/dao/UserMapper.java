package com.jmu.utim.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmu.utim.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
