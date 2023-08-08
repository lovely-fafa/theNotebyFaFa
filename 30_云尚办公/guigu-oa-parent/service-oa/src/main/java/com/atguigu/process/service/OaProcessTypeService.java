package com.atguigu.process.service;

import com.atguigu.model.process.ProcessType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface OaProcessTypeService extends IService<ProcessType> {
    List<ProcessType> findProcessType();
}
