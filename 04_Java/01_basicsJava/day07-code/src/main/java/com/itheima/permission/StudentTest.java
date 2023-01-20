package com.itheima.permission;

public class StudentTest {
    public static void main(String[] args) {
        Student stu = new Student();
        // stu.age = -23;
        stu.setAge(-23);

        System.out.println(stu.getAge());
    }
}
