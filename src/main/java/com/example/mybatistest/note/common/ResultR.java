package com.example.mybatistest.note.common;

/**
 * @program: IntelliJ IDEA
 * @description: 返回
 * @author: xusi
 * @create:2020-07-07 15:11
 **/
public class ResultR {
    public static R resultByBoolean(boolean flag){
        if (flag){
            return R.ok().message("成功");
        } else {
            return R.error().message("失败");
        }
    }
}
