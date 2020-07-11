package com.example.mybatistest.note.common;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: xusi
 * @create:2020-07-11 16:28
 **/
public class NoteException extends RuntimeException {

    private int code;
    private String msg;
    public NoteException(int code, String msg){
        this.code = code;
        this.msg = msg;
    };
// 不要使用
   private  NoteException(){};

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }



}
