package com.itheima.a01mymap;

import java.util.TreeMap;

public class A09_TreeMapDemo2 {
    public static void main(String[] args) {
        TreeMap<Student1, String> tm = new TreeMap<>();

        Student1 s1 = new Student1("张三", 23);
        Student1 s2 = new Student1("李四", 24);
        Student1 s3 = new Student1("王五", 25);

        tm.put(s1, "北京");
        tm.put(s2, "天津");
        tm.put(s3, "上海");

        System.out.println(tm);
    }
}
