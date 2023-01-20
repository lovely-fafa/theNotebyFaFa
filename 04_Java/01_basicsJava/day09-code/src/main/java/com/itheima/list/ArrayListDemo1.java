package com.itheima.list;

import java.util.ArrayList;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张三");
        list.add("李四");
        System.out.println(list);  // [张三, 张三, 李四]

        ArrayList<Double> list1 = new ArrayList<>();
        list1.add(1.1);
        list1.add(2.3);
        System.out.println(list1);  // [1.1, 2.3]
    }
}
