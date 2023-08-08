package com.atguigu.process.service;

import com.atguigu.model.process.ProcessTemplate;
import com.atguigu.model.process.ProcessType;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface OaProcessTemplateService extends IService<ProcessTemplate> {
    IPage<ProcessTemplate> selectPageProcessTemplate(Long page, Long limit);

    void publish(Long id);

}
