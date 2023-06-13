package com.jmu.utim.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Device {
    private Long id;

    private Long totalCheck;

    private Integer badPercent;

    private String totalRuntime;

    private Integer status;

    private LocalDateTime installDate;
}