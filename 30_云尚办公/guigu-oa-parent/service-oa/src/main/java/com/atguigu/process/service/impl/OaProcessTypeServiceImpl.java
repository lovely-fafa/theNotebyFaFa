package com.atguigu.process.service.impl;

import com.atguigu.model.process.ProcessTemplate;
import com.atguigu.model.process.ProcessType;
import com.atguigu.process.mapper.OaProcessTypeMapper;
import com.atguigu.process.service.OaProcessTypeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OaProcessTypeServiceImpl extends ServiceImpl<OaProcessTypeMapper, ProcessType> implements OaProcessTypeService {

    @Autowired
    private OaProcessTemplateServiceImpl processTemplateService;

    // 查询所有的审批分类和模板
    @Override
    public List<ProcessType> findProcessType() {
        List<ProcessType> processTypes = baseMapper.selectList(null);

        processTypes.forEach(processType -> {
            LambdaQueryWrapper<ProcessTemplate> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(ProcessTemplate::getProcessTypeId, processType.getId());
            lambdaQueryWrapper.eq(ProcessTemplate::getStatus, 1);
            List<ProcessTemplate> processTemplates = processTemplateService.list(lambdaQueryWrapper);
            processType.setProcessTemplateList(processTemplates);
        });
        return processTypes;
    }
}
