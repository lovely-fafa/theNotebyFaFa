package com.itheima.Integer;

public class IntegerMethodDemo {
    public static void main(String[] args) {

        int num = 100;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toOctalString(num));
        System.out.println(Integer.toHexString(num));

        String s = "100";
        System.out.println(s + 100);  // "100100"
        System.out.println(Integer.parseInt(s) + 100);  // 200
    }
}
