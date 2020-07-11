package com.example.mybatistest.note.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program: IntelliJ IDEA
 * @description: 自动填充
 * @author: xusi
 * @create:2020-07-07 13:31
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"gmtCreate", LocalDateTime.class,LocalDateTime.now());
        this.strictInsertFill(metaObject,"isDelete", Boolean.class,false);
        this.strictInsertFill(metaObject,"gmtModified", LocalDateTime.class,LocalDateTime.now());

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,"gmtModified", LocalDateTime.class,LocalDateTime.now());

    }
}
