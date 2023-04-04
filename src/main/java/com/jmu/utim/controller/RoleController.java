package com.jmu.utim.controller;

import com.jmu.utim.common.R;
import com.jmu.utim.entity.Role;
import com.jmu.utim.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/1")
    public R<List<Role>> getAll(){
        List<Role> list = new ArrayList<>();

        list = roleService.list();


        return R.success(list);
    }
}
