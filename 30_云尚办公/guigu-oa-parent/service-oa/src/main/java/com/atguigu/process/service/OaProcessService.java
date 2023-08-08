package com.atguigu.process.service;

import com.atguigu.model.process.ApprovalVo;
import com.atguigu.model.process.Process;
import com.atguigu.model.process.ProcessFormVo;
import com.atguigu.model.system.ProcessQueryVo;
import com.atguigu.model.system.ProcessVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

public interface OaProcessService extends IService<Process> {
    IPage<ProcessVo> selectPage(Page<ProcessVo> pageParam, ProcessQueryVo processQueryVo);

    // 部署流程定义
    void deployByZip(String zipPath);

    void startUp(ProcessFormVo processFormVo);

    IPage<ProcessVo> findPending(IPage<Process> pageParam);

    HashMap<String, Object> show(Long id);

    void approve(ApprovalVo approvalVo);

    IPage<ProcessVo> findProcessed(Page<Process> pageParam);

    IPage<ProcessVo> findStarted(Page<ProcessVo> pageParam);
}
