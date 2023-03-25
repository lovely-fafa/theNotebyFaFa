package com.itheima.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GirlFriend gf = new GirlFriend();

        while (true) {
            try {
                System.out.println("请输入名字：");
                String name = sc.nextLine();
                gf.setName(name);

                System.out.println("请输入年龄：");
                int age = Integer.parseInt(sc.nextLine());
                gf.setAge(age);

                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (AgeOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        System.out.println(gf);
    }
}
