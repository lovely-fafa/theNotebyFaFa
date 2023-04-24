package com.itheima;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.itheima.injectors.MySqlInjector;
import com.itheima.plugins.MyInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.SqlParameter;

import java.util.ArrayList;
import java.util.List;

@MapperScan("com.itheima.mapper")
@Configuration
public class MybatisPlusConfig {

    // 配置分页插件
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }


    // 注入拦截器
//    @Bean
    public MyInterceptor myInterceptor () {
        return new MyInterceptor();
    }

    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor() {

        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();

        List<ISqlParser> list = new ArrayList<>();
        // 添加了一个 全表删除更新的阻断器
        list.add(new BlockAttackSqlParser());
        sqlExplainInterceptor.setSqlParserList(list);

        return sqlExplainInterceptor;
    }

    /**
     * 注入自定义的 sql 注入器
     * @return
     */
    @Bean
    public MySqlInjector mySqlInjector() {
        return new MySqlInjector();
    }
}
