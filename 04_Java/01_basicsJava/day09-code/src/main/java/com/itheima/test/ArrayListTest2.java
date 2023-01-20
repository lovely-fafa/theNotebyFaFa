package com.itheima.test;

import com.itheima.domain.Student;

import java.util.ArrayList;

public class ArrayListTest2 {
    public static void main(String[] args) {
        Student stu1 = new Student("张飒", 12);
        Student stu2 = new Student("fafa", 19);
        Student stu3 = new Student("李四", 12);

        ArrayList<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getAge() < 18) {
                System.out.println(stu.getName() + "---" + stu.getAge());
            }
        }
    }
}
