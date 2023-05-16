package com.jmu.utim.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;



@Data
public class User {

    private Long id;
    //姓名
    private String username;

    private String password;

    private Long roleId;

    private Integer openStatus;

}
