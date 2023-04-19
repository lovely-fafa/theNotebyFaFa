package com.itheima;

import com.example.EnableHeaderConfig;
import com.example.HeaderGenerator;
import com.example.HeaderParser;
import com.example.TokenParser;
import com.google.gson.Gson;
import com.itheima.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@EnableHeaderConfig
@SpringBootTest
public class AutoConfigurationTests {

    @Autowired
    private Gson gson;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testJson() {
        String json = gson.toJson(Result.success());
        System.out.println(json);
    }

    @Test
    public void testTokenParser() {
        System.out.println(applicationContext.getBean(TokenParser.class));
    }

    @Test
    public void testHeaderParser() {
        System.out.println(applicationContext.getBean(HeaderParser.class));
    }

    @Test
    public void testHeaderGenerator() {
        System.out.println(applicationContext.getBean(HeaderGenerator.class));
    }
}
