package com.itheima.oop;

public class PhoneTest {
    public static void main(String[] args) {
        Phone p1 = new Phone();
        p1.brand = "小米";
        p1.color = "白色";
        p1.price = 4999;

        System.out.println(p1.brand + p1.color + p1.price);

        p1.call("发发");
        p1.sendMessage();
    }
}
