package com.jmu.utim.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmu.utim.entity.License;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface LicenseMapper extends BaseMapper<License> {
}
