package com.itheima.service.impl;

import dao.EmpDao;
import com.itheima.pojo.Emp;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component
@Service
public class EmpServiceA implements EmpService {

    // 面向接口编程
    // private EmpDao empDao = new EmpDaoA();

    // 交给 IOC 容器管理 成为 IOC 容器中 bean
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        // 1. 调用 dao 获取数据
        List<Emp> empList = empDao.listEmp();

        // 2. 数据处理
        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }

            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }
        });

        return empList;
    }
}
