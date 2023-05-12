package com.jmu.utim.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: lrui1
 * @description 工厂实体类
 * @date: 2023/5/12
 */
@TableName("tbl_factory")
@Data
public class Factory {
    private Long id;
    private String factoryName;
    private Long areaId;
}
