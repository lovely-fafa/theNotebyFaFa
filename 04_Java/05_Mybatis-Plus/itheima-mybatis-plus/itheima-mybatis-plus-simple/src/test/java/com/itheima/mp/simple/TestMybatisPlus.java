package com.itheima.mp.simple;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.itheima.mp.simple.mapper.UserMapper;
import com.itheima.mp.simple.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatisPlus {
    @Test
    public void testFindAll() throws IOException {
        // 1. 读取 mybatis 的核心配置文件(mybatis-config.xml)
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);

        // 2. 通过配置信息获取一个 SqlSessionFactory 工厂对象
        // 使用 mybatis plus 提供的 MybatisSqlSessionFactoryBuilder 进行构建 实现 mybatis 和插件的整合
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);

        // 3. 通过工厂获取一个 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. 找到要执行的 sql 语句并执行 sql 语句
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // List<User> users = userMapper.findAll();

        // 使用 mybatis 提供的方法
        List<User> users = userMapper.selectList(null);

        // 5. 输出结果
        for (User user : users) {
            System.out.println(user);
        }
    }
}
