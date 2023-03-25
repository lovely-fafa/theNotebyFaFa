package com.itheima.a03myfunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class FunctionDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "1", "2", "3", "4");

        // 匿名内部类
        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        }).forEach(s -> System.out.println(s));

        // 方法引用
        // 方法需要已经存在
        // 方法的形参和返回值需要跟抽象方法的形参和返回值保持一致
        // 方法的功能需要把形参的字符中转换成整数
        list.stream().map(Integer::parseInt).forEach(s -> System.out.println(s));
    }
}
