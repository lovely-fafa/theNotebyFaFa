package com.itheima.a02mylist;

import com.itheima.a01mycollection.Student;

import java.util.TreeSet;

public class A06_TreeSetDemo2 {
    public static void main(String[] args) {
        Student stu1 = new Student("zhangsan", 23);
        Student stu2 = new Student("lisi", 24);
        Student stu3 = new Student("wangwu", 25);

        TreeSet<Student> ts = new TreeSet<>();

        ts.add(stu1);
        ts.add(stu2);
        ts.add(stu3);

        System.out.println(ts);
        // [Student{name = zhangsan, age = 23}, Student{name = lisi, age = 24}, Student{name = wangwu, age = 25}]
    }
}
