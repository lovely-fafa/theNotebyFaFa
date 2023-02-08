package com.itheima.block;

public class BlockTest {
    public static void main(String[] args) {
        {
            // 局部代码块
            int num = 10;
            System.out.println(num);
        }
        // System.out.println(num);
    }
}

class Student {

    static String school;

    // 静态代码块
    static {
        school = "黑马程序员";
        System.out.println("Student 类的静态代码块");
    }

    // 构造代码块
    {
        System.out.println("Student 类的构造代码块");
        System.out.println("好好学习，天天向上");
    }

    public Student() {
        System.out.println("空参构造...");
    }

    public Student(int num) {
        System.out.println("带参构造...");
    }
}
