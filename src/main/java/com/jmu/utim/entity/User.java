package com.jmu.utim.entity;


import lombok.Data;



@Data
public class User {

    private Long id;
    //姓名
    private String username;

    private String password;
}
