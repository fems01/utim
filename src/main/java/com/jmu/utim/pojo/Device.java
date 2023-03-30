package com.jmu.utim.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Device {
    private Integer id;
    private Long totalCheck;
    private Long totalBad;

    private Double badPercent;
    private String totalRuntime;

    private Integer status;

    private LocalDateTime installDate;
}
