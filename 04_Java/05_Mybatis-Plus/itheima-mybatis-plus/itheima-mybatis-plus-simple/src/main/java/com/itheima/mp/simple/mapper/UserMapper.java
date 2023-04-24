package com.itheima.mp.simple.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.mp.simple.pojo.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    public List<User> findAll();
}
