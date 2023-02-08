package com.itheima.a02myset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class A01_SetDemo1 {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();

        // 1. 添加元素
        // 如果当前元素是第一次添加，那么可以添加成功，返回 true
        // 如果当前元素是第二次添加，那么添加失败，返回 false
        boolean r1 = s.add("aaa");  // true
        boolean r2 = s.add("aaa");  // false
        boolean r3 = s.add("bbb");  // true
        boolean r4 = s.add("ccc");  // true

        // 迭代器遍历
        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            String res = it.next();
            System.out.println(res);
        }

        // 增强 for
        for (String s1 : s) {
            System.out.println(s1);
        }

        // Lambda 表达式
        s.forEach(new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        });

        s.forEach(s1 -> System.out.println(s1));
    }
}
