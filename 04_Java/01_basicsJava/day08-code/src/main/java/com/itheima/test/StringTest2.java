package com.itheima.test;

import java.util.Scanner;

public class StringTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入手机号：");
        String tel = sc.nextLine();

        String star = tel.substring(0, 3);
        String end = tel.substring(7);

        System.out.println(star + "****" + end);
    }
}
