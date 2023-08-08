package com.atguigu.auth.activiti;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MyTaskListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        if ("经理审批".equals(delegateTask.getName())) {
            delegateTask.setAssignee("jack");
        } else if ("人事审批".equals(delegateTask.getName())) {
            delegateTask.setAssignee("tom");
        }
    }
}
