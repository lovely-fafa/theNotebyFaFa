package com.itheima.a01immutable;

import java.util.Iterator;
import java.util.Set;

public class ImmutableDemo2 {
    public static void main(String[] args) {
        // 创建不可变的 set 集合时 要保证参数的唯一性
        Set<String> set = Set.of("张三", "李四", "王五");

        for (String s : set) {
            System.out.println(s);
        }

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
