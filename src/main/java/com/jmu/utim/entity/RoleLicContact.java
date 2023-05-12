package com.jmu.utim.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: lrui1
 * @description 角色与许可信息联系表
 * @date: 2023/5/11
 */
@TableName("tbl_role_lic_contact")
@Data
public class RoleLicContact {
    private Long roleId;
    private Long licId;
}
