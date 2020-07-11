package com.example.mybatistest.note.controller;


import com.example.mybatistest.note.common.R;
import com.example.mybatistest.note.common.ResultR;
import com.example.mybatistest.note.entity.Message;
import com.example.mybatistest.note.entity.User;
import com.example.mybatistest.note.service.impl.MessageServiceImpl;
import com.example.mybatistest.note.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 留言表 前端控制器
 * </p>
 *
 * @author xusi
 * @since 2020-07-07
 */
@RestController
@RequestMapping("/note/message")
public class MessageController {
    @Resource
    private MessageServiceImpl messageService;
    @GetMapping("/all")
    @ApiOperation("获取所有留言")
    public R getAll(){
        List<Message> list = messageService.list();
        return R.ok().data("messages",list);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id获取留言")
    public R getOne(@ApiParam(name = "id",value = "id") @PathVariable Integer id){
        Message message = messageService.getById(id);
        return R.ok().data("message",message);
    }

    @ApiOperation("插入")
    @PostMapping("/insert")
    public R insert(Message message){
        boolean flag = messageService.save(message);
        return ResultR.resultByBoolean(flag);
    }

    @ApiOperation("删除操作")
    @DeleteMapping("/{id}")
    public R deleteById(@ApiParam(name = "id",value = "id")@PathVariable Integer id){
        boolean flag = messageService.removeById(id);
        return ResultR.resultByBoolean(flag);
    }
    @ApiOperation("update")
    @PutMapping("/update")
    public R updateById(Message message){
        boolean flag = messageService.updateById(message);
        return ResultR.resultByBoolean(flag);
    }
}

