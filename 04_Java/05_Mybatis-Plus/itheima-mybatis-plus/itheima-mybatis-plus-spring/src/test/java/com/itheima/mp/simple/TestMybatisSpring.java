package com.itheima.mp.simple;

import com.itheima.mp.simple.mapper.UserMapper;
import com.itheima.mp.simple.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath: applicationContext.xml")
public class TestMybatisSpring {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
