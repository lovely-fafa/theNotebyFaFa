package com.itheima.mySwitch;

import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args) {
        mySwitch(2);
    }

    public static void mySwitch(int age) {
        switch (age) {
            case 1:
                System.out.println("1岁");
                break;
            case 2:
                System.out.println("2岁");
                break;
            default:
                System.out.println("其他");
                break;
        }
    }

    // Switch 穿透
    public static void mySwitch1() {
        int week = 1;
        switch (week) {
            case 1:
                System.out.println("星期一");
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            default:
                System.out.println("您的输入有误");
                break;
        }
    }
    // 多个 case 有相同的代码 可以用 Switch 穿透优化
    public static void mySwitch3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("00");
        int week = sc.nextInt();
        switch (week) {
            case 1, 2, 3, 5, 4:
                System.out.println("工作日");
                break;
            case 6, 7:
                System.out.println("休息日");
                break;
            default:
                System.out.println("您的输入有误");
                break;
        }
    }
    // 代码简化
    public static void mySwitch4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("00");
        int week = sc.nextInt();
        switch (week) {
            case 1, 2, 3, 5, 4 -> System.out.println("工作日");
            case 6, 7 -> System.out.println("休息日");
            default -> System.out.println("您的输入有误");
        }
    }
}
