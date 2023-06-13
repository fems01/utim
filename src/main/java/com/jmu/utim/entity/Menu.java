package com.jmu.utim.entity;

import lombok.Data;

/**
 * @author: lrui1
 * @description 菜单类
 * @date: 2023/6/12
 */
@Data
public class Menu {
    private Long id;
    private String name;
    private String menuCode;
    private Long parentId;
    private Integer nodeType;
    private String iconUrl;
    private Integer sort;
    private String linkUrl;
    private Integer level;
    private String path;
    private Integer isDelete;
}
