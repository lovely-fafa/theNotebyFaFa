package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.enums.SexEnum;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
public class TestUserMapper {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert1() {
        User user = new User(null, "fafa", "123456", "发发", 18, "136@163.com", null, null, null, SexEnum.WOMAN);
        int result = userMapper.insert(user);
        log.info("插入{}行数据：{}", result, user);
        // 自增长的 id 会回填到 user 里面 发发我呀 大为震惊
        log.info("id为{}", user.getId());
    }

    @Test
    public void testInsert2() {
        User user = new User(null, "fafa", "123456", "发发", 18, "136@163.com", null,null, null, SexEnum.WOMAN);
        user.setAddress("四川");
        int result = userMapper.insert(user);
        log.info("插入{}行数据：{}", result, user);

        log.info("id为{}", user.getId());
    }

    // 更新
    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(5L);  // 条件
        user.setName("fafa");  // 更新这个值
        int result = userMapper.updateById(user);
        log.info("修改{}行数据：{}", result, user);
    }

    @Test
    public void testUpdate1() {
        // 准备更新的数据
        User user = new User();
        user.setAge(20);
        user.setPassword("666666");

        // 更新条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "zhangsan");  // 匹配 user_name 为 zhangsan 的用户

        int result = userMapper.update(user, wrapper);
        log.info("修改{}行数据：{}", result, user);
    }

    @Test
    public void testUpdate2() {
        // 更新字段 + 条件
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_name", "zhangsan").set("name", "fafa").set("password", "99999");

        int result = userMapper.update(null, wrapper);
        log.info("修改{}行数据", result);
    }

    // 删除
    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(2L);
        log.info("删除了{}条数据", result);
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "wangwu");
        map.put("password", "123456");

        // 根据 map 删除 多条件之间是 and
        int result = userMapper.deleteByMap(map);
        log.info("删除了{}条数据", result);
    }

    @Test
    public void testDelete1() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "lisi")
                .eq("password", "123456");

        int result = userMapper.delete(wrapper);
        log.info("删除了{}条数据", result);
    }

    @Test
    public void testDelete2() {
        User user = new User();
        user.setPassword("888888");
//        user.setName("zhaoliu");

        QueryWrapper<User> wrapper = new QueryWrapper<>(user);

        int result = userMapper.delete(wrapper);
        log.info("删除了{}条数据", result);
    }

    @Test
    public void testDeleteBatchIds() {
        // 批量删除
        int result = userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
        log.info("删除了{}条数据", result);
    }

    // 查新
    @Test
    public void testSelectById() {
        User result = userMapper.selectById(4L);
        log.info("查询到了 {}", result);
    }

    @Test
    public void testSelectBatchByIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4, 5, 6));
        for (User user : users) {
            log.info("查询到了: {}", user);
        }
    }

    @Test
    public void testSelectOne() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "fafa").eq("id", "1648964096160178183");
        // 查询数据超过 1 条会超出异常
        // 1 条或 null 就不会报错
        User user = userMapper.selectOne(wrapper);
        log.info("查询到一条结果为：{}", user);
    }

    @Test
    public void testSelectCount() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 条件 age 大于 20 的用户
        wrapper.gt("age", 20);
        Integer count = userMapper.selectCount(wrapper);
        log.info("查询到 {} 条数据", count);
    }

    @Test
    public void testSelectList() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email", "@163.com");
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            log.info("{}", user);
        }
    }

    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(1, 1);  // 查询第一页 查询 2 条数据
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email", "@163.com");

        Page<User> iPager = userMapper.selectPage(page, wrapper);

        log.info("数据总条数：{}", iPager.getTotal());
        log.info("数据总页数：{}", iPager.getPages());
        log.info("当前页：{}", iPager.getCurrent());

        List<User> records = iPager.getRecords();
        for (User record : records) {
            log.info("{}", record);
        }
    }

    /**
     * 测试自定义方法
     */
    @Test
    public void testFindById() {
        User user = userMapper.findById(1648964096160178192L);
        log.info("{}", user);
    }

    // 条件构造器
    @Test
    public void testAllEq() {
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "fafa");
        map.put("email", "136.com");
        map.put("password", null);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 用法一
        // wrapper.allEq(map);

        // 用法二
        // false: null 值不作为条件 is null
        // wrapper.allEq(map, false);

        // 用法
        // map 中的键值对 是否作为条件 取决于箭头函数返回的结果是 true 还是 false
        wrapper.allEq((k, v) -> (k.equals("age") || k.equals("id")), map);

        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            log.info("{}", user);
        }
    }

    // 比较操作
    @Test
    public void testEq() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("password", "123456")
                .gt("age", 18)
                .in("name", "张三", "发发");
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            log.info("{}", user);
        }
    }

    // 模糊匹配
    @Test
    public void testLike() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("password", "345")
                .likeRight("name", "张");
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            log.info("{}", user);
        }
    }

    // 排序
    @Test
    public void testOrderByAgeDesc() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            log.info("{}", user);
        }
    }

    @Test
    public void testOr(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "fafa")
                .or().eq("age", 20);
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            log.info("{}", user);
        }
    }

    // select
    @Test
    public void testSelect() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "fafa")
                .or()
                .eq("age", 20)
                .likeLeft("email", "@163.com")
                .select("id", "password", "age");
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            log.info("{}", user);
        }
    }

    /**
     * 测试 自定义的 sql 注入器
     */
    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            log.info("{}", user);
        }
    }
}
