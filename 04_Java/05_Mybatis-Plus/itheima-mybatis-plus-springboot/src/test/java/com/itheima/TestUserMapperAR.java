package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.enums.SexEnum;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
public class TestUserMapperAR {

    // 根据主键查询
    @Test
    public void testSelectById() {
        User user = new User();
        user.setId(4L);
        User user1 = user.selectById();
        log.info("{}", user1);
    }

    // 插入数据
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("fafa");
        user.setUserName("fafafafa");
        user.setAge(20);
//        user.setPassword("555555s");
        user.setMail("54321@163.com");

        boolean bool = user.insert();
        log.info("插入数据 {}，是否成功 {}", user, bool);
    }

    // 更新数据
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1L);
        user.setAge(100);
        boolean bool = user.updateById();
        log.info("更新数据 {}，结果为 {}", user, bool);
    }

    // 删除数据
    @Test
    public void testDelete() {
        User user = new User();
        user.setId(4L);
        boolean bool = user.deleteById();
        log.info("删除数据：{}，结果为 {}", user, bool);
    }

    // 查询数据
    @Test
    public void testSelect() {
        User user = new User();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("id", 100);
        List<User> users = user.selectList(wrapper);

        for (User user1 : users) {
            log.info("{}", user1);
        }
    }

    /**
     * 测试全表更新 sql 分析器的阻断效果
     */
    @Test
    public void testUpdateAll() {
        User user = new User();
        user.setAge(105);

        boolean bool = user.update(null);  // 全表更新
        log.info("{}", bool);
    }

    /**
     * 测试乐观锁
     */
    @Test
    public void testUpdateVersion(){
        User user = new User();
        user.setId(5L);
        // 先查版本
        User userVersion = user.selectById();
        // 修改数据
        user.setAge(80);
        user.setVersion(userVersion.getVersion());  // 读到当前版本
        // UPDATE tb_user SET age=80, version=2 WHERE id=5 AND version=1
        // 这个 更新的 2 就是插件自增的
        boolean bool = user.updateById();
        log.info("更新数据 {}，结果为 {}", user, bool);
    }

    /**
     * 测试枚举
     */
    @Test
    public void testEnum() {
        User user = new User();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("sex", SexEnum.WOMAN);
        List<User> users = user.selectList(wrapper);
        for (User user1 : users) {
            log.info("{}", user1);
        }
    }





}
