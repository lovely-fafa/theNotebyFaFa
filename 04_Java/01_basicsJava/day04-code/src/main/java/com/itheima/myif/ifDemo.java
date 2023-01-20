package com.itheima.myif;

public class ifDemo {

    public static void main(String[] args) {
        ifTest(18);
    }
    public static void ifTest(int age) {

        if (age > 18) {
            System.out.println("可以去网吧...");
        } else if (age == 18) {
            System.out.println("不知道");
        } else {
            System.out.println("不可以");
        }
    }
}
