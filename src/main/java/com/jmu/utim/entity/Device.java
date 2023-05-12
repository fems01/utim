package com.jmu.utim.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lrui1 and fems01
 */
@TableName("tbl_device")
@Data
public class Device {
    private Long id;
    private Long factoryId;
    private Long totalCheck;
    private Long totalBad;
    private Integer badPercent;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

    /**
     * 0无效 1有效 2报修
     */
    private Integer devStatus;
}
