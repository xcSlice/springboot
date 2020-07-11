package com.example.mybatistest.note.controller;


import com.example.mybatistest.note.common.R;
import com.example.mybatistest.note.common.ResultR;
import com.example.mybatistest.note.entity.Message;
import com.example.mybatistest.note.entity.Work;
import com.example.mybatistest.note.service.impl.WorkServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 作品表 前端控制器
 * </p>
 *
 * @author xusi
 * @since 2020-07-07
 */
@RestController
@RequestMapping("/note/work")
//nacos配置自动更新
//@RefreshScope
public class WorkController {
    @Resource
    private WorkServiceImpl workService;

    @Cacheable(value = "noteWork",key = "'getAllWork'")
    @GetMapping("/all")
    @ApiOperation("获取所有留言")
    public R getAll(){
        List<Work> list = workService.list();
        return R.ok().data("work",list);
    }

    @Cacheable(value = "noteWork",key = "'get'+#id")
    @GetMapping("/{id}")
    @ApiOperation("根据id获取留言")
    public R getOne(@ApiParam(name = "id",value = "id") @PathVariable Integer id){
        Work work = workService.getById(id);
        return R.ok().data("message",work);
    }

    @ApiOperation("插入")
    @PostMapping("/insert")
    public R insert(Work work){
        boolean flag = workService.save(work);
        return ResultR.resultByBoolean(flag);
    }
// #id 是否能获取到id的值
    @CacheEvict(value = "noteWork",key = "'delete'+#id")
    @ApiOperation("删除操作")
    @DeleteMapping("/{id}")
    public R deleteById(@ApiParam(name = "id",value = "id")@PathVariable Integer id){
        boolean flag = workService.removeById(id);
        return ResultR.resultByBoolean(flag);
    }

    @CachePut(value = "noteWork",key = "'update'")
    @ApiOperation("update")
    @PutMapping("/update")
    public R updateById(Work work){
        boolean flag = workService.updateById(work);
        return ResultR.resultByBoolean(flag);
    }
}

