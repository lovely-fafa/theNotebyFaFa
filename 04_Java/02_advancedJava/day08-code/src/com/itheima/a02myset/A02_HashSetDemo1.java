package com.itheima.a02myset;

public class A02_HashSetDemo1 {
    public static void main(String[] args) {
        Student stu1 = new Student("张三", 23);
        Student stu2 = new Student("张三", 23);

        System.out.println(stu1.hashCode());  // 24022543
        System.out.println(stu2.hashCode());  // 24022543

        System.out.println("abc".hashCode());  // 96354
        System.out.println("acD".hashCode());  // 96354
    }
}
