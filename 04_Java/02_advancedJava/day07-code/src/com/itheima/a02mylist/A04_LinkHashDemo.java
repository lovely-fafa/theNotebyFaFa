package com.itheima.a02mylist;

import com.itheima.a01mycollection.Student;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class A04_LinkHashDemo {
    public static void main(String[] args) {
        Student stu1 = new Student("zhangsan", 23);
        Student stu2 = new Student("lisi", 23);
        Student stu3 = new Student("zhangsan", 23);
        Student stu4 = new Student("zhangsan", 203);

        LinkedHashSet<Student> lhs = new LinkedHashSet<>();

        System.out.println(lhs.add(stu1));
        System.out.println(lhs.add(stu2));
        System.out.println(lhs.add(stu3));
        System.out.println(lhs.add(stu4));

        System.out.println(lhs);

    }
}
