package com.itheima.a01myexception;

public class ExceptionDemo4 {
    public static void main(String[] args) {
        // 作用二：异常可以作为方法内部的一种特殊返回值，以便通知调用者底层的执行情况
        Student s1 = new Student();
        s1.setAge(50);
    }
}
