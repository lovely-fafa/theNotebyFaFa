package com.itheima.test;

import java.util.ArrayList;

public class ArrayListTest1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张三1");
        list.add("张三2");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
