package com.itheima.test;

import com.itheima.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        Student stu = new Student("23", "fafa", 23, "2020");
        list.add(stu);

        while (true) {
            System.out.println("-欢迎来到学生管理系统-");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择:");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(list);
                    break;
                case 2:
                    deleteStudentById(list);
                    break;
                case 3:
                    updateStudentInfoById(list);
                    break;
                case 4:
                    queryStudentInfos(list);
                    break;
                case 5:
                    System.out.println("感谢你的使用，谢谢...");
                    System.exit(0);
                    break;
            }
        }
    }

    private static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学号：");
        String inputId;
        while (true) {
            inputId = sc.nextLine();
            if (getIndex(inputId, list) == -1) {
                break;
            } else {
                System.out.println("学号重复，请重新输入...");
            }
        }

        System.out.println("请输入新的学生姓名：");
        String name = sc.next();
        System.out.println("请输入新的年龄姓名：");
        int age = sc.nextInt();
        System.out.println("请输入新的生日姓名：");
        String birthday = sc.next();

        Student stu = new Student(inputId, name, age, birthday);
        System.out.println("添加成功");
    }

    private static void updateStudentInfoById(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号：");
        String inputId = sc.nextLine();

        int i = getIndex(inputId, list);
        if (i == -1) {
            System.out.println("不存在...");
        } else {
            System.out.println("请输入新的学生姓名：");
            String name = sc.next();
            System.out.println("请输入新的年龄姓名：");
            int age = sc.nextInt();
            System.out.println("请输入新的生日姓名：");
            String birthday = sc.next();

            Student stu = new Student(inputId, name, age, birthday);
            list.set(i, stu);
        }
    }

    private static int getIndex(String id, ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private static void deleteStudentById(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号：");
        String inputId = sc.nextLine();

        int i = getIndex(inputId, list);
        if (i == -1) {
            System.out.println("不存在...");
        } else {
            list.remove(i);
        }
    }

    private static void queryStudentInfos(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("查无信息，前添加后重试！");
        } else {
            System.out.println("学号\t姓名\t年龄\t生日");
            for (Student stu: list) {
                System.out.println(stu.getId() + "\t" +  stu.getName() + "\t" +  stu.getAge() + "\t" +  stu.getBirthday());
            }
        }
    }
}
