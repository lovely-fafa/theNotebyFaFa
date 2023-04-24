package com.itheima.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    // 插入数据时填充
    @Override
    public void insertFill(MetaObject metaObject) {
        // 获取到 password 的值
        Object password = getFieldValByName("password", metaObject);

        if (null == password) {
        // 如果为空 填充
            setFieldValByName("password", "888888", metaObject);
        }
    }

    // 更新数据时填充
    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
