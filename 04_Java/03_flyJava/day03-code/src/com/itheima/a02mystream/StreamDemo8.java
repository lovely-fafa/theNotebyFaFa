package com.itheima.a02mystream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class StreamDemo8 {
    public static void main(String[] args) {
        // 输出每一个人的年龄
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张无忌-10", "周芷若-50", "赵镇-30", "张-20");

        // 类型装换之匿名内部类

        // 第一个类型：流中原有是数据类型
        // 第二个类型：转换为什么类型

        // apply 的形参 s ：依次表示流里面的每一个数据
        // 返回值：表示转换后的数据
        list1.stream().map(new Function<String, Integer>() {

            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s.split("-")[1]);
            }
        }).forEach(s -> System.out.println(s));

        // 类型装换之 Lambda 表达式
        list1.stream().map(s -> Integer.parseInt(s.split("-")[1])).forEach(s -> System.out.println(s));
    }
}
