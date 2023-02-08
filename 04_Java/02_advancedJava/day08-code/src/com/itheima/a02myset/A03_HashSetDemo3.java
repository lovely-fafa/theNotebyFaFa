package com.itheima.a02myset;

import java.util.HashSet;

public class A03_HashSetDemo3 {
    public static void main(String[] args) {
        Student stu1 = new Student("zhangsan", 23);
        Student stu2 = new Student("lisi", 23);
        Student stu3 = new Student("zhangsan", 23);
        Student stu4 = new Student("zhangsan", 203);

        HashSet<Student> hs = new HashSet<>();
        System.out.println(hs.add(stu1));  // true
        System.out.println(hs.add(stu2));  // true
        System.out.println(hs.add(stu3));  // false
        System.out.println(hs.add(stu4));  // true

        System.out.println(hs);
    }
}
