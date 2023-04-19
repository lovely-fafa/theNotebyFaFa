package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    // 根据 id 删除数据
    @Delete("delete from emp where id = #{id}")
    // public void delete(Integer id);
    public int delete(Integer id);

    // 新增数据
    @Options(useGeneratedKeys = true,  // 要获取返回主键
            keyProperty = "id")  // 赋值给 emp 的 id 属性
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

    // 更新数据
    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, entrydate = #{entryDate}, dept_id = #{deptId} where id = #{id}")
    public void update(Emp emp);

    // 根据 id 查询
//    @Select("select * from emp where id = #{id}")
//    public Emp getById(Integer id);

    // 解决方法一：给字段起别名 让别名和实体类的属性一致
//    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id deptId, create_time crrateTime, update_time updateTime from emp where id = #{id}")
//    public Emp getById(Integer id);

    // 解决方法二：通过 @Results 与 @Result 手动映射封装
//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select * from emp where id = #{id}")
//    public Emp getById(Integer id);

    // 解决方法三：开启 mybatis 的驼峰命名自动映射开关 --- a_column --> aColumn
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

    // 根据条件查询
    // 此处使用 #{} 是写死到字符串里面的 是不对的 所以这个地方就使用了 ${} 进行字符串的拼接
    // @Select("select * from emp where name like '%${name}%' and gender = #{gender} and entrydate between #{begin} and #{end} order by update_time desc")
    // 也可以使用 字符串 的拼接函数 concat
    // @Select("select * from emp where name like concat('%', #{name} , '%') and gender = #{gender} and entrydate between #{begin} and #{end} order by update_time desc")
    public List<Emp> list(String name, Object gender, LocalDate begin, LocalDate end);

    // 动态更新数据
    public void update2(Emp emp);

    // 批量删除
    public void deleteByIds(List<Integer> ids);


}




