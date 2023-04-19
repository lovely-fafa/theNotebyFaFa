package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    void update(Dept dept);
}
