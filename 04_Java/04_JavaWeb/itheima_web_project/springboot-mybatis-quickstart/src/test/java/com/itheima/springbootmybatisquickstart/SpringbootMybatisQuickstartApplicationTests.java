package com.itheima.springbootmybatisquickstart;

import com.itheima.springbootmybatisquickstart.mapper.UserMapper;
import com.itheima.springbootmybatisquickstart.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest  // springboot 整合单元测试的注解
class SpringbootMybatisQuickstartApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testListUser() {
		List<User> userList = userMapper.list();

		userList.stream().forEach(user -> {
			System.out.println(user);
		});
	}

}
