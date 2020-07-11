package com.example.mybatistest.note.service.impl;

import com.example.mybatistest.note.entity.Work;
import com.example.mybatistest.note.mapper.WorkMapper;
import com.example.mybatistest.note.service.IWorkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 作品表 服务实现类
 * </p>
 *
 * @author xusi
 * @since 2020-07-07
 */
@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements IWorkService {

}
