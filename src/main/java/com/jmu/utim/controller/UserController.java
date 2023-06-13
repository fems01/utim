package com.jmu.utim.controller;


import com.jmu.utim.common.R;
import com.jmu.utim.entity.User;
import com.jmu.utim.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/users")
@RequiresPermissions("user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

//    @Autowired
//    private RedisTemplate redisTemplate;

    @PostMapping("/1")
    public R<String> sendMessage(){
        return R.error("短信发送失败");
    }

    @GetMapping
    public R<List<User>> getAll(){
        List<User> list = userService.list();
        return R.success(list);
    }

    @GetMapping("/{id}")
    public R<User> getById(@PathVariable Long id) {
        User role = userService.getById(id);
        return R.success(role);
    }

    @PostMapping
    public R<String> save(@RequestBody User user) {
        // 给密码加密 加盐salt
        String newPassword = new SimpleHash("md5", user.getPassword(), "salt", 3).toString();
        user.setPassword(newPassword);
        // 存进数据库
        userService.save(user);
        return R.success("添加成功！！！");
    }

    @PutMapping
    public R<String> update(@RequestBody User user){
        // 有更新密码 给密码加密 加盐salt
        if(user.getPassword() != null) {
            String newPassword = new SimpleHash("md5", user.getPassword(), "salt", 3).toString();
            user.setPassword(newPassword);
        }
        // 存进数据库
        userService.updateById(user);
        return R.success("更新成功");
    }

    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable Long id) {
        userService.removeById(id);
        return R.success("删除成功");
    }

/*

=======
    /*
>>>>>>> 45d8ab3a6662b0f590769f2e800eccee2d34886e
    @PostMapping
    public R<String> login(@RequestBody Map map){
        String username = map.get("username").toString();

        String password = map.get("password").toString();

        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken token = new UsernamePasswordToken(username,password);

        LambdaQueryWrapper<User>  queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(User::getUsername,username);

        queryWrapper.eq(User::getPassword,password);

        User one = userService.getOne(queryWrapper);

        if(one!=null){
            redisTemplate.opsForValue().set(username,1,5, TimeUnit.MINUTES);
            return R.success("success");
        }
        return R.error("error");
    }

*/
//    @GetMapping("/1")
//    public R<String> login(){
//        Subject subject = SecurityUtils.getSubject();
//        AuthenticationToken token = new UsernamePasswordToken("张三","z3");
//        subject.login(token);
//        return R.success("ok");
//    }

//    @PostMapping("/login")
//    @ResponseBody
//    public R<String> userLogin(@RequestBody User user,@RequestParam(defaultValue = "false") boolean rememberMe){
//        Subject subject = SecurityUtils.getSubject();
//
//        String username = user.getUsername();
//        String password = user.getPassword();
////        System.out.println(user);
////        System.out.println(rememberMe);
//        AuthenticationToken token = new UsernamePasswordToken(username,password,rememberMe);
//        try {
//            subject.login(token);
//            System.out.println(token);
//            return R.success("ok");
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//            System.out.println("error");
//            return R.success("no");
//        }
//    }
}
