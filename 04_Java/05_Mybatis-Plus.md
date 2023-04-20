2023年4月19日16:00发发我呀开始学习mybatis-plus咯

# 课程介绍 Mybatis-Plus

- 了解 Mybatis-Plus
- 整合 Mybatis-Plus
- 通用CRUD
- Mybatis-Plus的配置
- 条件构造器

# 1 了解 Mybatis-Plus

## 1.1 Mybatis-Plus 介绍

- MyBatis-Plus（简称 MP）是一个 MyBatis 的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发提高效率而生。
- 官网：https://mybatis.plus/或https://baomidou.com/

<img src="https://baomidou.com/img/logo.svg" style="zoom: 33%;" />

## 1.2 代码及文档

- 文档地址：https://mybatis.plus/guide/
- 代码地址：https://github.com/baomidou/mybatis-plus

## 1.3 特性

- 无侵入：只做增强不做改变，引入它不会对现有工程产生影响，如丝般顺滑
- 损耗小：启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作
- 强大的 CRUD 操作：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作更有强大的条件构造器，满足各类使用需求
- 支持 Lambda 形式调用：通过 Lambda 表达式，方便的编写各类查询条件，无需再担心字段写错支持多种数据库: 支持 MySQL、MariaDB、Oracle、DB2、H2、HSQL、SQLite、 PostgreSQLServer2005、SQLServer 等多种数据库
- 支持主键自动生成:支持多达 4 种主键策略（内含分布式唯id 生成器-Sequene），可自由配置，完美解决主键问题
- 支持XML 热加载：Mapper 对应的 XML 支持热加载，对于简单的 CRUD 操作，甚至可以无XML 启动
- 支持ActiveRecord 模式：支持 AtiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD操作
- 支持自定义全局通用操作：支持全局通用方法注入（Write once, use anywhere）
- 支持关键词自动转义：支持数据库关键词（order、key......）自动转义，还自定义关键词
- 内置代码生成器：采用代码或者 Maven 插件可快速生成 Mapper 、Model、Service 、Controller 层代码，支持模板引擎，更有超多自定义配置等您来使用
- 内置分页插件：基于 MyBatis 物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于普通 List询
- 内置性能分析插件：可输出 SQL 语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询
- 内置全局拦截插件：提供全表 delete 、 update 操作智能分析阻断，也可自定义拦截规则，预防误操作

## 1.4 架构

![image-20230419191940607](assets/image-20230419191940607.png)

## 1.5 作者

- Mybatis-Plus 是由 baomidou（苞米豆）组织开发并且开源的，目前该组织大概有30人左右
- 码云地址: https://gitee.com/organizations/baomidou

# 2 快速开始

对于 Mybatis 整合 MP 有常常有三种用法，分别是 Mybatis+MP、Spring+Mybatis+MP、SpringBoot+Mybatis+MP

## 2.1 创建数据库及表

```sql
-- 创建测试表
CREATE TABLE `tb_user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_name` varchar(20) NOT NULL COMMENT '用户名',
    `password` varchar(20) NOT NULL COMMENT '密码',
    `name` varchar(30) DEFAULT NULL COMMENT '姓名',
    `age` int(11) DEFAULT NULL COMMENT '年龄',
    `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 插入测试数据
INSERT INTO `tb_user` (`id`, `user_name`, `password`, `name`, `age`, `email`) VALUES ('1', 'zhangsan', '123456', '张三', '18', 'test1@itcast.cn');
INSERT INTO `tb_user` (`id`, `user_name`, `password`, `name`, `age`, `email`) VALUES ('2', 'lisi', '123456', '李四', '20', 'test2@itcast.cn');
INSERT INTO `tb_user` (`id`, `user_name`, `password`, `name`, `age`, `email`) VALUES ('3', 'wangwu', '123456', '王五', '28', 'test3@itcast.cn');
INSERT INTO `tb_user` (`id`, `user_name`, `password`, `name`, `age`, `email`) VALUES ('4', 'zhaoliu', '123456', '赵六', '21', 'test4@itcast.cn');
INSERT INTO `tb_user` (`id`, `user_name`, `password`, `name`, `age`, `email`) VALUES ('5', 'sunqi', '123456', '孙七', '24', 'test5@itcast.cn');
```

## 2.2 搭环境

logf4

```properties
log4f.rootLogger=DEBUG,A1

log4j.appender.A1=org.apache.log4j.ConsoleAppender
log4j.appender.A1.layout=org.apache.log4j.PatternLayout
log4j.appender.Al.layout.ConversionPattern=[%t] [%c]-[%p] %m%n
```

## 2.3 Mybatis + MP

### 2.3.1 Mybatis 实现查询 User

- 第一步：创建 mybatis-config.xml 配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <!--    开启大驼峰命名法转换    -->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://127.0.0.1:3306/mp?
useUnicode=true&amp;characterEncoding=utf8&amp;autoReconnect=true&amp;allowMultiQuerie
s=true&amp;useSSL=false"/>
                <property name="username" value="root"/>
                <property name="password" value="555555s"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="UserMapper.xml"/>
    </mappers>
</configuration>
```

- 第二步：编写 User 实体对象

```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String userName;
    private String name;
    private Integer age;
    private String email;
}
```

- 第三步：编写 UserMapper 接口

```java
public interface UserMapper {
    public List<User> findAll();
}
```

- 第四步：编写 UserMapper.xml 文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.itheima.mp.simple.mapper.UserMapper">
    <select id="findAll" resultType="com.itheima.mp.simple.pojo.User">
        select * from tb_user
    </select>
</mapper>
```

- 第五步：测试

```java
import com.itheima.mp.simple.mapper.UserMapper;
import com.itheima.mp.simple.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void testFindAll() throws IOException {
        // 1. 读取 mybatis 的核心配置文件(mybatis-config.xml)
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);

        // 2. 通过配置信息获取一个 SqlSessionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3. 通过工厂获取一个 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. 找到要执行的 sql 语句并执行 sql 语句
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findAll();

        // 5. 输出结果
        for (User user : users) {
            System.out.println(user);
        }
    }
}

```

### 2.3.2 Mybatis + MP 实现查询 User

- 第一步：将 UserMapper 继承 BaseMapper，将拥有了 BaseMapper 中的所有方法

```java
public interface UserMapper extends BaseMapper<User> {
    public List<User> findAll();
}
```

- 表名映射

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_user")  // 表名进行映射
public class User {
    private Long id;
    private String userName;
    ...
}
```

- 第二步：使用 MP 中的 MybatisSglSessionFactoryBuilder 进程构建

```java
import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.itheima.mp.simple.mapper.UserMapper;
import com.itheima.mp.simple.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatisPlus {
    @Test
    public void testFindAll() throws IOException {
        // 1. 读取 mybatis 的核心配置文件(mybatis-config.xml)
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);

        // 2. 通过配置信息获取一个 SqlSessionFactory 工厂对象
        // 使用 mybatis plus 提供的 MybatisSqlSessionFactoryBuilder 进行构建 实现 mybatis 和插件的整合
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);

        // 3. 通过工厂获取一个 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. 找到要执行的 sql 语句并执行 sql 语句
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // List<User> users = userMapper.findAll();

        // 使用 mybatis 提供的方法
        List<User> users = userMapper.selectList(null);

        // 5. 输出结果
        for (User user : users) {
            System.out.println(user);
        }
    }
}
```

##  2.4 Spring + Mybatis + MP

引入了Spring框架，数据源、构建等工作就交给了 Spring 管理

## 2.5 SpringBoot + Mybatis + Mp

使用 SpringBoot 将进一步的简化 MP 的整合，需要注意的是，由于使用 SpringBoot 需要继承 parent，所以需要重新创
建工程，并不是创建子 Module

# 3 通用 CRUD

## 3.1 插入

### 3.1.1 id 增长策略

```java
package com.baomidou.mybatisplus.annotation;
import lombok.Getter;
/**
* 生成ID类型枚举类
*
* @author hubin
* @since 2015-11-10
*/
@Getter
public enum IdType {
    /**
    * 数据库ID自增
    */
    AUTO(0),
    
    /**
    * 该类型为未设置主键类型
    */
    NONE(1),
    
    /**
    * 用户输入ID
    * 该类型可以通过自己注册自动填充插件进行填充
    */
    INPUT(2),
    
    /* 以下3种类型、只有当插入对象ID 为空，才自动填充。 */
    /**
    * 全局唯一ID (idWorker)
    */
    ID_WORKER(3),
    
    /**
    * 全局唯一ID (UUID)
    */
    UUID(4),

    /**
    * 字符串全局唯一ID (idWorker 的字符串表示)
    */
    ID_WORKER_STR(5);
    
    private final int key;
    
    IdType(int key) {
    	this.key = key;
    }
}
```

### 3.1.2 修改 User 的 id 自增

```java
@TableName("tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // 设置 id 模式是 auto 自增
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName ;
    ...
}
```

### 3.1.3 插入代码

```java
@Test
public void testInsert() {
    User user = new User(null, "fafa", "123456", "发发", 18, "136@163.com");
    int result = userMapper.insert(user);
    log.info("插入{}行数据：{}", result, user);
    // 自增长的 id 会回填到 user 里面 发发我呀 大为震惊
    log.info("id为{}", user.getId());
}
```

### 3.1.4 @TableField 注解

- 在 MP 中通过`@TableField`注解可以指定字段的一些属性，常常解决的问题有2个
  - 对象中的属性名和字段名不一致的问题（非驼峰）：驼峰会自动转换
  - 对象中的属性字段在表中不存在的问题：不写该值到数据库
  - 安全问题：不查该值

```java
public class User {
    // 设置 id 模式是 auto 自增
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName ;

    // 查询时不查该值
    @TableField(select = false)
    private String password;
    private String name;
    private Integer age;

    // 指定数据库中的字段名 进行映射对应
    @TableField(value = "email")
    private String mail;

    // 数据表中不存在该字段 就不会报错: Unknown column 'address' in 'field list'
    @TableField(exist = false)
    private String address;
}
```

## 3.2 更新

### 3.2.1 根据 id 更新

```java
/**
* 根据 ID 修改
*
* @param entity 实体对象
*/
int updateById(@Param(Constants.ENTITY) T entity);
```

```java
@Test
public void testUpdateById() {
    User user = new User();
    user.setId(5L);  // 条件
    user.setName("fafa");  // 更新这个值
    int result = userMapper.updateById(user);
    log.info("修改{}行数据：{}", result, user);
}
```

### 3.2.2 根据条件更新

```java
/**
* 根据 whereEntity 条件，更新记录
*
* @param entity 实体对象 (set 条件值,可以为 null)
* @param updateWrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成 where 语句）
*/
int update(@Param(Constants.ENTITY) T entity, @Param(Constants.WRAPPER) Wrapper<T> updateWrapper);
```

- 更新方法一

```java
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
```

- 更新方法二

```java
@Test
public void testUpdate2() {
    // 更新字段 + 条件
    UpdateWrapper<User> wrapper = new UpdateWrapper<>();
    wrapper.eq("user_name", "zhangsan").set("name", "fafa").set("password", "99999");

    int result = userMapper.update(null, wrapper);
    log.info("修改{}行数据", result);
}
```

## 3.3 删除

### 3.3.1 根据 id 删除

```java
/**
* 根据 ID 删除
*
* @param id 主键ID
*/
int deleteById(Serializable id);
```

```java
@Test
public void testDeleteById() {
    int result = userMapper.deleteById(2L);
    log.info("删除了{}条数据", result);
}
```

### 3.3.2 根据 map 删除

```java
/**
* 根据 columnMap 条件，删除记录
*
* @param columnMap 表字段 map 对象
*/
int deleteByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
```

```java
@Test
public void testDeleteByMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("user_name", "wangwu");
    map.put("password", "123456");

    // 根据 map 删除 多条件之间是 and
    int result = userMapper.deleteByMap(map);
    log.info("删除了{}条数据", result);
}
```

### 3.3.3 delete

```java
/**
* 根据 entity 条件，删除记录
*
* @param wrapper 实体对象封装操作类（可以为 null）
*/
int delete(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
```

- 方法一

```java
@Test
public void testDelete1() {
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.eq("user_name", "lisi")
            .eq("password", "123456");

    int result = userMapper.delete(wrapper);
    log.info("删除了{}条数据", result);
}
```

- 方法二：基于面向对象的 更推荐

```java
@Test
public void testDelete2() {
    User user = new User();
    user.setPassword("123456");
    user.setName("zhaoliu");

    QueryWrapper<User> wrapper = new QueryWrapper<>(user);

    int result = userMapper.delete(wrapper);
    log.info("删除了{}条数据", result);
}
```

### 3.3.4  根据 id 批量删除

```java
/**
* 删除（根据 ID 批量删除）
*
* @param idList 主键 ID 列表(不能为 null 以及 empty)
*/
int deleteBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
```

```java
@Test
public void testDeleteBatchIds() {
    // 批量删除
    int result = userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
    log.info("删除了{}条数据", result);
}
```

## 3.4 查询

### 3.4.1 根据 id 查询

```java
/**
* 根据 ID 查询
*
* @param id 主键ID
*/
T selectById(Serializable id);
```

```java
@Test
public void testSelectById() {
    User result = userMapper.selectById(4L);
    log.info("查询到了 {}", result);
}
```

### 3.4.2 根据 id 批量查询

```java
/**
* 查询（根据 ID 批量查询）
*
* @param idList 主键 ID 列表（不能为 null 以及 empty）
*/
List<T> selectBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
```

```java
@Test
public void testSelectBatchByIds() {
    List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4, 5, 6));
    for (User user : users) {
        log.info("查询到了: {}", user);
    }
}
```

### 3.4.3 查询一条

```java
/**
* 根据 entity 条件，查询一条记录
*
* @param queryWrapper 实体对象封装操作类（可以为 null）
*/
T selectOne(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
```

```java
@Test
public void testSelectOne() {
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.eq("user_name", "fafa").eq("id", "1648964096160178183");
    // 查询数据超过 1 条会超出异常
    // 1 条或 null 就不会报错
    User user = userMapper.selectOne(wrapper);
    log.info("查询到一条结果为：{}", user);
}
```











