package com.example.day02code;
import java.util.Scanner;
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 整数
        int age = sc.nextInt();
        System.out.println(age);
        // 浮点数
        double width = sc.nextDouble();
        System.out.println(width);
    }
}
