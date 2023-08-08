package com.atguigu.wechat.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.auth.service.SysUserService;
import com.atguigu.model.process.Process;
import com.atguigu.model.process.ProcessTemplate;
import com.atguigu.model.system.SysUser;
import com.atguigu.process.service.OaProcessService;
import com.atguigu.process.service.OaProcessTemplateService;
import com.atguigu.wechat.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.joda.time.DateTime;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
public class MessageServiceImpl implements MessageService {

    @Resource
    private OaProcessService processService;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private OaProcessTemplateService processTemplateService;
    @Resource
    private WxMpService wxMpService;

    // 推送给待审批人
    @Override
    public void pushPendingMessage(Long processId, Long userId, String taskId) {
        // 查需要的数据
        Process process = processService.getById(processId);
        SysUser user = sysUserService.getById(userId);
        ProcessTemplate template = processTemplateService.getById(taskId);
        // 提交人信息
        SysUser submitUser = sysUserService.getById(process.getUserId());

        // 发送消息
        WxMpTemplateMessage build = WxMpTemplateMessage.builder()
                .toUser(user.getOpenId())
                .templateId("xxx-xxx-xxx")  // wechat官网里面自定义的模板的id
                .url("")  // 点击后跳转
                .build();

        // 设置模板里面的具体值
        JSONObject jsonObject = JSON.parseObject(process.getFormValues());
        JSONObject formShowData = jsonObject.getJSONObject("formShowData");
        StringBuffer content = new StringBuffer();
        for (Map.Entry entry : formShowData.entrySet()) {
            content.append(entry.getKey()).append("：").append(entry.getValue()).append("\n ");
        }

        build.addData(new WxMpTemplateData("first",
                submitUser.getName() + "提交了" + template.getName() + "审批申请，请注意查看。", "#272727"));
        build.addData(new WxMpTemplateData("keyword1",
                process.getProcessCode(), "#272727"));
        build.addData(new WxMpTemplateData("keyword2",
                new DateTime(process.getCreateTime()).toString("yyyy-MM-dd HH:mm:ss"), "#272727"));
        build.addData(new WxMpTemplateData("content",
                content.toString(), "#272727"));
        String msg;
        try {
            msg = wxMpService.getTemplateMsgService().sendTemplateMsg(build);
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }
        log.info("推送消息返回：{}", msg);
    }
}
