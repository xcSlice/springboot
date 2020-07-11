package com.example.mybatistest.note.controller;

import com.example.mybatistest.note.common.R;
import com.example.mybatistest.note.entity.User;
import com.example.mybatistest.note.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: IntelliJ IDEA
 * @description: 登录
 * @author: xusi
 * @create:2020-07-11 16:13
 **/

@RestController("note/user")
public class LoginController {

    @Resource
    private UserServiceImpl userService;
    private Logger log = LoggerFactory.getLogger(LoginController.class);
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public R login(@RequestBody User user){
        log.info(user.toString());
        String token = userService.login(user);
        return R.ok().data("token",token);
    }
}
