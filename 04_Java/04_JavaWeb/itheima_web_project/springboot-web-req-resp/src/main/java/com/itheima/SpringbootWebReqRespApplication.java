package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// 重新配置
// "dao": 需要额外扫描的包
// "com.itheima": 当前类及其子包 由于重新配置会覆盖掉默认的 所以这个地方要重新写出来
@ComponentScan({"dao", "com.itheima"})
@SpringBootApplication  // 默认扫描当前包及其子包
public class SpringbootWebReqRespApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebReqRespApplication.class, args);
    }

}
