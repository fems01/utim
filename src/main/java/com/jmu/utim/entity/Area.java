package com.jmu.utim.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: lrui1
 * @description 地区实体类
 * @date: 2023/5/12
 */
@TableName("tbl_area")
@Data
public class Area {
    private Long id;
    private String areaName;
}
