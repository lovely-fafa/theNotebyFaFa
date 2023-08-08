package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"com.atguigu.auth", "com.atguitu.common", "com.atguigu.process",
        "com.atguigu.security.config", "com.atguigu.security.custom", "com.atguigu.security.filter",
        "com.atguigu.wechat"
})
@MapperScan(basePackages = {"com.atguigu.process.mapper", "com.atguigu.auth.mapper", "com.atguigu.wechat.mapper"})
@EnableTransactionManagement(proxyTargetClass = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }
}
