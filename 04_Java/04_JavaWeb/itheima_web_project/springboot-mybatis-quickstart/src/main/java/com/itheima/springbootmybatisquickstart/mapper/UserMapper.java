package com.itheima.springbootmybatisquickstart.mapper;

import com.itheima.springbootmybatisquickstart.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper  // 在运行时 会自动生成框架的实现类对象 并将该对象交给 IOC 容器
public interface UserMapper {

    @Select("select id, name, age, gender, phone from user")
    public List<User> list();

}
