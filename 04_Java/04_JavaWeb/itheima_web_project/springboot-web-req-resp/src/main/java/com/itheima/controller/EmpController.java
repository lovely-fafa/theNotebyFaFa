package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.service.impl.EmpServiceA;
import com.itheima.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

// `@RestController` = `@Controller` + `@ResponseBody`
@RestController
public class EmpController {

    // 面向接口编程
    // private EmpService empService = new EmpServiceA();

    // 运行时，IOC 容器会提供该类型的 bean 对象，并赋值给该变量 - 依赖注入
    // @Autowired
    // @Qualifier("empServiceA")
    @Resource(name = "empServiceA")
    private EmpService empService;

    @RequestMapping("listEmp")
    public Result list() {
        // 1. 调用 services 获取数据
        List<Emp> empList = empService.listEmp();

        // 2. 响应数据
        return Result.success(empList);
    }
}
