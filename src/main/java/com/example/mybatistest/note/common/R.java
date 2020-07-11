package com.example.mybatistest.note.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: IntelliJ IDEA
 * @description: 统一返回值
 * @author: xusi
 * @create:2020-07-07 12:51
 **/
public class R {
    private String status;
    private String message;
    private Integer code;
    private Map<String,Object> data = new HashMap();
    private R(){}

    public static R ok(){
        R r = new R();
        r.setStatus("ok");
        r.setCode(200);
        return r;
    }
    public static R error(){
        R r = new R();
        r.setStatus("error");
        r.setCode(400);
        return r;
    }

    public R message(String msg){
        this.setMessage(msg);
        return this;
    }

    public R data(String key,Object obj){
        this.data.put(key, obj);
        return this;
    }

    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

    public String getStatus() {
        return status;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    private void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
