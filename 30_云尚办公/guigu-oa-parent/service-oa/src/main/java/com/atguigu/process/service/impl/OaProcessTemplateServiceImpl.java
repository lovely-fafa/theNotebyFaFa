package com.atguigu.process.service.impl;

import com.atguigu.model.process.ProcessTemplate;
import com.atguigu.model.process.ProcessType;
import com.atguigu.process.mapper.OaProcessTemplateMapper;
import com.atguigu.process.service.OaProcessService;
import com.atguigu.process.service.OaProcessTemplateService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.activiti.engine.impl.bpmn.helper.ScopeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class OaProcessTemplateServiceImpl extends ServiceImpl<OaProcessTemplateMapper, ProcessTemplate> implements OaProcessTemplateService {

    @Autowired
    private OaProcessTypeServiceImpl processTypeService;
    @Autowired
    private OaProcessService processService;

    @Override
    public IPage<ProcessTemplate> selectPageProcessTemplate(Long page, Long limit) {
        IPage<ProcessTemplate> pageParam = new Page<>(page, limit);
        IPage<ProcessTemplate> processTemplateIPage = baseMapper.selectPage(pageParam, null);

        List<ProcessTemplate> records = processTemplateIPage.getRecords();
        records.forEach(processTemplate -> {
            ProcessType processType = processTypeService.getById(processTemplate.getProcessTypeId());
            if (processType != null) {
                processTemplate.setProcessTypeName(processType.getName());
            }
        });

        return processTemplateIPage;
    }

    @Override
    public void publish(Long id) {
        ProcessTemplate processTemplate = baseMapper.selectById(id);
        // 发布
        if (StringUtils.hasText(processTemplate.getProcessDefinitionPath())) {
            try {
                processService.deployByZip(processTemplate.getProcessDefinitionPath());
                // 修改状态为 1
                processTemplate.setStatus(1);
                baseMapper.updateById(processTemplate);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
