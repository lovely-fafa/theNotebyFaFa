package com.itheima.oop;

public class StudentTest {
    public static void main(String[] args) {
        // 1.创建类
        Student stu1 = new Student();
        System.out.println(stu1);  // com.itheima.oop.Student@5d099f62

        // 2.使用对象成员变量
        System.out.println(stu1.name);
        System.out.println(stu1.age);

        // 3.使用对象成员方法
        stu1.eat();
        stu1.drink();
    }
}
