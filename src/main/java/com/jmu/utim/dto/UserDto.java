package com.jmu.utim.dto;

import com.jmu.utim.pojo.Device;
import com.jmu.utim.pojo.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto extends User {
    private List<Device> flavors = new ArrayList<>();

    private String roleId;

    private Integer copies;
}
