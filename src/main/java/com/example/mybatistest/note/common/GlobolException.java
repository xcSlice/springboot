package com.example.mybatistest.note.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: IntelliJ IDEA
 * @description: 全局异常
 * @author: xusi
 * @create:2020-07-07 13:29
 **/
@ControllerAdvice
public class GlobolException {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public R global(Exception e){
        return R.error().message("处理全局异常").data("error",e);
    }

    //自定义异常
    @ExceptionHandler(NoteException.class)
    public R error(NoteException e){
        e.printStackTrace();
        return R.error().data("code",e.getCode()).message(e.getMsg());
    }
}
