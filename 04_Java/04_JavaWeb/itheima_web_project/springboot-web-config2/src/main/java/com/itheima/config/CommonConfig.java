package com.itheima.config;

import com.itheima.service.DeptService;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    // 声明第三方 bean
    // 我们可以使用 @bean 的 name 或 value 属性指定名称 未设置则默认是方法名
    @Bean  // 将当前方法的返回值对象交给 IOC 容器管理，成为 IOC 器 bean
    public SAXReader reader(DeptService deptService) {
        System.out.println(deptService);
        return new SAXReader();
    }
}
