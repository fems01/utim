package com.jmu.utim.entity;

import lombok.Data;

/**
 * @author: lrui1
 * @description 角色菜单联系类
 * @date: 2023/6/12
 */
@Data
public class RoleMenu {
    private Long id;
    private Long roleId;
    private Long menuId;
}
