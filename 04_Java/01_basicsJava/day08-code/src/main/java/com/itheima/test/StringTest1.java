package com.itheima.test;

import java.util.Scanner;

public class StringTest1 {
    /*
        需求:键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数(不考虑其他字符)

        例如:aAb3&c2B4CD1

        小写字母:3个
        大写字母:4个
        数字字母:4个
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String input = sc.nextLine();

        int small = 0;
        int big = 0;
        int number = 0;

        for (char i : input.toCharArray()) {
            if (i > 'a' && i < 'z') {
                small ++;
            } else if (i > 'A' && i < 'Z') {
                big ++;
            } else if (i > '0' && i < '9') {
                number ++;
            }
        }

        System.out.println("小写字符：" + small + "个");
        System.out.println("大写字符：" + big + "个");
        System.out.println("数字字符：" + number + "个");
    }
}
