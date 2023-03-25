package com.itheima.a01myreflect1;

public class MyReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 第一种方法
        // 全类名：com.itheima.a01myreflect1.Student
        // 最常用
        Class clazz1 = Class.forName("com.itheima.a01myreflect1.Student");

        // 2. 第二种
        // 参数传递
        // 比如说 加锁时
        Class clazz2 = Student.class;

        // 3. 第三种
        // 有了这个类时 可以使用
        Student student = new Student();
        Class clazz3 = student.getClass();

        System.out.println(clazz1 == clazz2);  // true
        System.out.println(clazz2 == clazz3);  // true
    }
}
