package com.atguigu.wechat.service;

public interface MessageService {

    /**
     * 推送给待审批人
     * @param processId
     * @param userId
     * @param TaskId
     */
    void pushPendingMessage (Long processId, Long userId, String TaskId);
}
