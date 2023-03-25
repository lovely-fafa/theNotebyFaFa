package com.itheima.a01myexception;

public class ExceptionDemo3 {
    // 作用一：异常是用来查询 bug 的关键参考信息
    public static void main(String[] args) {
        Student2 stu = new Student2("zhangsan-23");  // Index 1 out of bounds for length 1
        System.out.println(stu.getName());
    }
}
