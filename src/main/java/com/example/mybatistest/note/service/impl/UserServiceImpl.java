package com.example.mybatistest.note.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.mybatistest.note.common.JwtUtils;
import com.example.mybatistest.note.common.NoteException;
import com.example.mybatistest.note.controller.LoginController;
import com.example.mybatistest.note.entity.User;
import com.example.mybatistest.note.mapper.UserMapper;
import com.example.mybatistest.note.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xusi
 * @since 2020-07-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    public String login(User user) {
        String pw = user.getPw();
        String name = user.getUsername();
        log.info(pw);
        log.info(name);
//        存在一个为空,抛出异常
        if(StringUtils.isEmpty(pw) || StringUtils.isEmpty(name)){
            throw new NoteException(500,"用户名或者 id 为空");
        }
//        查询数据库中是否存在 对于的 pw,name
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",name)
                .eq("pw",pw);
        User userOnDB = getOne(wrapper);
        if (userOnDB == null){
            throw new NoteException(500,"用户名或者密码错误");
        }
//        判读用户名是否正确
        if (!userOnDB.getUsername().equals(name)){
            throw new NoteException(500,"用户名不正确");
        }

//        判断密码是否正确
//        如果密码已加密,
//        if(!userOnDB.getPw().equals(加密类(String pw))){
        if(!userOnDB.getPw().equals(pw)){
            throw new NoteException(500,"密码不正确");
        }

//        返回 token
        String token = JwtUtils.getToken(userOnDB.getId().toString(),name);
        return token;
    }
}
