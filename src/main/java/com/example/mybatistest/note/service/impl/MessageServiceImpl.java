package com.example.mybatistest.note.service.impl;

import com.example.mybatistest.note.entity.Message;
import com.example.mybatistest.note.mapper.MessageMapper;
import com.example.mybatistest.note.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 留言表 服务实现类
 * </p>
 *
 * @author xusi
 * @since 2020-07-07
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
