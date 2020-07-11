package com.example.mybatistest.note.service;

import com.example.mybatistest.note.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xusi
 * @since 2020-07-07
 */
public interface IUserService extends IService<User> {
    public String login(User user);

}
