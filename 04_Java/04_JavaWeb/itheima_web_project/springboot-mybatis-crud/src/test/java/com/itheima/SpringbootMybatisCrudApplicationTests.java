package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    //    @Test
    void contextLoads() {
        int delete = empMapper.delete(14);
        System.out.println(delete);
    }

//    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("Tom2");
        emp.setName("汤姆2");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntryDate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(19);

        empMapper.insert(emp);

        System.out.println(emp.getId());
    }

//    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("Tom000 2");
        emp.setName("汤000姆 2");
        emp.setJob((short) 1);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.update2(emp);
    }

//    @Test
    public void testGetById() {
        Emp emp = empMapper.getById(19);
        System.out.println(emp);
    }

    @Test
    public void testList(){
//        List<Emp> list = empMapper.list("张", (short) 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        List<Emp> list = empMapper.list(null, null, null, null);
        list.stream().forEach(emp -> {
            System.out.println(emp);
        });
    }

//    @Test
    public void testDeleteByIds() {
        List<Integer> ids = Arrays.asList(11, 12, 13);
        empMapper.deleteByIds(ids);
    }
}
