package com.example.day02code;
import java.util.Scanner;
public class ScannerTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入您的姓名：");
        String name = sc.next();

        System.out.println("请输入您的年龄：");
        int age = sc.nextInt();

        System.out.println("请输入您的身高：");
        double width = sc.nextDouble();

        System.out.println("请输入你的婚姻状况：");
        boolean flag = sc.nextBoolean();

        System.out.println("注册成功");
    }
}
