package com.itheima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.pojo.User;

import java.util.List;

public interface MyBaseMapper<T> extends BaseMapper<T> {
    List<T> findAll();
}
