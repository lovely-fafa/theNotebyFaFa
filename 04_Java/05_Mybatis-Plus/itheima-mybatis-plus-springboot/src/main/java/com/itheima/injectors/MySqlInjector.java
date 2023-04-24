package com.itheima.injectors;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.ArrayList;
import java.util.List;

public class MySqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {

        // 获取父类 即 DefaultSqlInjector 中返回的 List<AbstractMethod>
        List<AbstractMethod> list = super.getMethodList(mapperClass);

        // 添加我们自定义的
        list.add(new FindAll());
        return list;
    }
}
