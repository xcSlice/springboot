package com.example.mybatistest.note.controller;


import com.example.mybatistest.note.common.R;
import com.example.mybatistest.note.common.ResultR;
import com.example.mybatistest.note.entity.User;
import com.example.mybatistest.note.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xusi
 * @since 2020-07-07
 */
@RestController
@RequestMapping("/note/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @Cacheable(value = "noteUser",key = "'getAllUser'") //查询放入redis
    @GetMapping("/all")
    @ApiOperation("获取所有用户")
    public R getAll(){
        List<User> users = userService.list();
        return R.ok().data("users",users);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id获取用户")
    public R getOne(@ApiParam(name = "id",value = "id") @PathVariable Integer id){
        User user = userService.getById(id);
        return R.ok().data("users",user);
    }


    @ApiOperation("插入")
    @PostMapping("/insert")
    public R insert(User user){
        boolean flag = userService.save(user);
        return ResultR.resultByBoolean(flag);
    }

//    @CacheEvict
    @ApiOperation("删除操作")
    @DeleteMapping("/{id}")
    public R deleteById(@ApiParam(name = "id",value = "id")@PathVariable Integer id){
        boolean flag = userService.removeById(id);
        return ResultR.resultByBoolean(flag);
    }
    @ApiOperation("update")
    @PutMapping("/update")
    public R updateById(User user){
        boolean flag = userService.updateById(user);
        return ResultR.resultByBoolean(flag);
    }
}

