package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {

    // 原始方式
    @RequestMapping("/simpleParam1")
    public String simpleParam1(HttpServletRequest request) {
        // 获取参数
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");

        int age = Integer.parseInt(ageStr);
        System.out.println(name + " - " + age);
        return "OK";
    }

    // 基于 SpringBoot
    @RequestMapping("/simpleParam2")
    public String simpleParam2(String name, Integer age) {
        System.out.println(name + " - " + age);
        return "OK";
    }

    @RequestMapping("/simpleParam3")
    public String simpleParam3(String username, Integer age) {
        System.out.println(username + " - " + age);
        return "OK";
    }

    // 如果方法形参名称与请求参数名称不匹配，可以使用`@RequestParam`完成映射。
    // `@RequestParam中`的`required`属性默认为`true`，代表该请求参数必须传递，如果不传递将报错。
    // 如果该参数是可选的，可以将`required`属性设置为`false`。
    @RequestMapping("/simpleParam4")
    public String simpleParam4(@RequestParam(name = "name", required = false) String username, Integer age) {
        System.out.println(username + " - " + age);
        return "OK";
    }

    // 2. 实体参数
    // 2.1简单实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "Ok";
    }

    // 2.2 复杂实体参数
    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        System.out.println(user);
        return "Ok";
    }

    // 3. 数组集合参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "Ok";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "Ok";
    }

    // 4. 日期时间参数
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "OK";
    }

    // 5. Json 参数
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "OK";
    }

    // 6. 路径参数
    @RequestMapping("/path/{id}/{username}")
    public String pathParam(@PathVariable Integer id, @PathVariable String username) {
        System.out.println(id + " - " + username);
        return "OK";
    }
}
