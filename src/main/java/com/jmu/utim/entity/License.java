package com.jmu.utim.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("tbl_lic")
public class License {
    private Long id;

    private String licName;

    @TableField("lic_desc")
    private String description;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

    /**
     * 1有效，0无效
     */
    private Integer openStatus;

    public License() {
    }

    public License(Long id, String licName, String description) {
        this.id = id;
        this.licName = licName;
        this.description = description;
    }
}
