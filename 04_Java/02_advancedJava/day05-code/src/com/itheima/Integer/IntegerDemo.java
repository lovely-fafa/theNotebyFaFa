package com.itheima.Integer;

public class IntegerDemo {
    public static void main(String[] args) {

    }

    private static void demo1() {
        int num = 10;
        Integer i1 = Integer.valueOf(num);
        System.out.println(i1);

        int i = i1.intValue();
        System.out.println(i);
    }
    private static void demo2() {
        int num = 10;
        Integer i1 = num;
        System.out.println(i1);

        int i = i1;
        System.out.println(i);
    }
}
