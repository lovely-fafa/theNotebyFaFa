package com.itheima.a02mystream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class StreamDemo6 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵镇", "张", "张三丰", "张攀山", "张良", "王二麻子", "谢广坤");

        // 1. 过滤
        // 匿名内部类
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张");
            }
        }).forEach(s -> System.out.println(s));
        // Lambda 表达式
        list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));

        // 2. 获取前几个
        list.stream().
                limit(3).  // 前 3 个
                forEach(s -> System.out.println(s));

        // 3. 跳过前几个
        list.stream()
                .skip(3)  // 跳过前 3 个
                .forEach(s -> System.out.println(s));
    }
}
