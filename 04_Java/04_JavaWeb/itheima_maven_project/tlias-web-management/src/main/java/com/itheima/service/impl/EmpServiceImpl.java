package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        // 1. 获取 总记录数
        // Long count = empMapper.count();

        // 2. 获取 分页查询的结果
        // List<Emp> empList = empMapper.page((page - 1) * pageSize, pageSize);

        // 3. 封装并返回 PageBean
        // return new PageBean(count, empList);

        // 1. 设置分页参数
        PageHelper.startPage(page, pageSize);
        log.info("name：是{}，比较是{}", name, name != null);

        // 2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);

        Page<Emp> p = (Page<Emp>) empList;

        // 3. 封装并返回 PageBean
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);

    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.geyByUsernameAndPassword(emp);
    }
}
