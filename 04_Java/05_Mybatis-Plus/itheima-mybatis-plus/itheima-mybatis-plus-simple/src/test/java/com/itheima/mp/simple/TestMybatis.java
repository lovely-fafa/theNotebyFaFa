package com.itheima.mp.simple;

import com.itheima.mp.simple.mapper.UserMapper;
import com.itheima.mp.simple.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void testFindAll() throws IOException {
        // 1. 读取 mybatis 的核心配置文件(mybatis-config.xml)
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);

        // 2. 通过配置信息获取一个 SqlSessionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3. 通过工厂获取一个 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. 找到要执行的 sql 语句并执行 sql 语句
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findAll();

        // 5. 输出结果
        for (User user : users) {
            System.out.println(user);
        }
    }
}
