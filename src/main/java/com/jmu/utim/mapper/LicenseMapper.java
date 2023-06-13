package com.jmu.utim.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmu.utim.entity.License;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;


@Mapper
public interface LicenseMapper extends BaseMapper<License> {
    /**
     * 根据用户名查询对应的信息CODE集合
     */
    String GET_PERMISSIONS_SQL = "SELECT lic.`code`\n" +
            "FROM role_lic_contact rlc\n" +
            "JOIN role r on rlc.role_id = r.id\n" +
            "JOIN license lic on rlc.lic_id = lic.id\n" +
            "WHERE r.id=(\n" +
            "SELECT role_id from `user` WHERE username=#{username}\n" +
            ")";
    @Select(GET_PERMISSIONS_SQL)
    Set<String> getPermissionsByName(String username);
}
