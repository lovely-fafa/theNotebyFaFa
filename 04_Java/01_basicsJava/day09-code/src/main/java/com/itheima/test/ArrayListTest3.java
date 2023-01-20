package com.itheima.test;

import com.itheima.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest3 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            addStudentInfo(list);
        }

    }

    private static void addStudentInfo(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();

        list.add(new Student(name, age));
    }
}
