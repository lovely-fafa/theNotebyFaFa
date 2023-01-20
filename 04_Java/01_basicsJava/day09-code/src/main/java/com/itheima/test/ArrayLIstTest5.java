package com.itheima.test;

import com.itheima.domain.Student;

import java.util.ArrayList;

public class ArrayLIstTest5 {
    /*
        需求:定义一个方法，方法接收一个集合对象 (泛型为Student)
            方法内部将年龄低于18的学生对象找出
            并存入新集合对象，方法返回新集合
     */
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("张三", 17));
        list.add(new Student("李四", 108));
        list.add(new Student("王五", 180));

        ArrayList<Student> newList = filter(list);
        for (Student stu : newList) {
            System.out.println(stu.getName() + " --- " + stu.getAge());
        }
    }

    private static ArrayList<Student> filter(ArrayList<Student> list) {
        ArrayList<Student> newList = new ArrayList<>();
        for (Student stu : list) {
            if (stu.getAge() < 18) {
                newList.add(stu);
            }
        }
        return newList;
    }
}
