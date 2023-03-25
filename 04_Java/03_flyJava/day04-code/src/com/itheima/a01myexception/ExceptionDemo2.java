package com.itheima.a01myexception;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        // 作用一：异常是用来查询 bug 的关键参考信息
        Student[] arr = new Student[3];

        String name = arr[0].getName();  // NullPointerException
        System.out.println(name);
    }
}
