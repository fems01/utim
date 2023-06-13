package com.jmu.utim.controller;

import com.jmu.utim.common.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lrui1
 * @description 登录控制器
 * @date: 2023/6/4
 */
@CrossOrigin
@RestController
public class LogController {
    @GetMapping("/toLogin")
    public R<String> toLogin() {
        return R.success("请先登录");
    }

    @PostMapping("/login")
    public R<String> login(@RequestParam String username, @RequestParam String password) {
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        return R.success("登录成功！");
    }

    @GetMapping("/logout")
    public R<String> logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return R.success("登出成功！");
    }
}
