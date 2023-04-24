package com.itheima.plugins;


import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.util.Properties;
import java.util.concurrent.Executor;

@Intercepts({@Signature(
        type = Executor.class,  // 拦截的类型
        method = "update",  // 拦截 Executor 的 update 方法
        args = {
                MappedStatement.class,
                Object.class
        }
)})
public class MyInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 拦截方法，具体的逻辑编写位置
        return null;
    }

    @Override
    public Object plugin(Object target) {
        // 创建 target 对象的代理对象，目的是将当前拦截器加入到该对象中
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        // 属性设置
        Interceptor.super.setProperties(properties);
    }
}