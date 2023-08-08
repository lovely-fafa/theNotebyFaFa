package com.atguigu.auth.service.utils;

import com.atguigu.auth.mapper.OaProcessRecordMapper;
import com.atguigu.auth.service.OaProcessRecordService;
import com.atguigu.model.process.ProcessRecord;
import com.atguigu.process.service.OaProcessService;
import com.atguigu.security.custom.LoginUserInfoHelper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OaProcessRecordServiceImpl extends ServiceImpl<OaProcessRecordMapper, ProcessRecord> implements OaProcessRecordService {

    @Override
    public void record(Long processId, Integer status, String description) {
        ProcessRecord processRecord = new ProcessRecord();
        processRecord.setProcessId(processId);
        processRecord.setStatus(status);
        processRecord.setDescription(description);
        processRecord.setOperateUser(LoginUserInfoHelper.getUsername());
        processRecord.setOperateUserId(LoginUserInfoHelper.getUserId());
        baseMapper.insert(processRecord);
    }
}
