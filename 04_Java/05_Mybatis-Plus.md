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























