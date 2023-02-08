package com.itheima.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[] args) {
        String data = "我的电话是：13619088888 + 我的电话是：13619088888 + 我的电话是：13619088888 + 我的电话是：13619088882";
        // 定义正则表达式
        String regex = "1[3-9]\\d{9}";
        // 将正则表达式封装为一个 Pattern 对象
        Pattern pattern = Pattern.compile(regex);
        // 获取匹配器对象
        Matcher matcher = pattern.matcher(data);
        // 通过匹配器，从内容中爬取信息
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
