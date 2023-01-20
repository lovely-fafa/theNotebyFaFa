package com.itheima.constructor;

public class StudentTest {
    public static void main(String[] args) {
        Student stu1 = new Student("张三", 14);
        System.out.println(stu1.name + stu1.age);

        Student stu2 = new Student("发发", 22);
        System.out.println(stu2.name + stu2.age);
    }
}
