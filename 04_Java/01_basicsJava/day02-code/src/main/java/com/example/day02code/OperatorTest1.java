package com.example.day02code;
import java.util.Scanner;
public class OperatorTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        int ge = num % 10;

        System.out.println("整数" + num + "的个位为" + ge);
    }
}
