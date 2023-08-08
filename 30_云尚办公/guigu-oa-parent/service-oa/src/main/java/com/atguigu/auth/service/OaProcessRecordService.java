package com.atguigu.auth.service;

import com.atguigu.model.process.ProcessRecord;
import com.baomidou.mybatisplus.extension.service.IService;

public interface OaProcessRecordService extends IService<ProcessRecord> {
    void record(Long processId, Integer status, String description);

}
