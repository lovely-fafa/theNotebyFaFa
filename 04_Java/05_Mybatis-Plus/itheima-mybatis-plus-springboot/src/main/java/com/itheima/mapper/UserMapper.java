package com.itheima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper extends MyBaseMapper<User> {

    User findById(Long id);
}
