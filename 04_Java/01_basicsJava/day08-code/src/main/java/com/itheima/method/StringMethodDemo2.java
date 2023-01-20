package com.itheima.method;

public class StringMethodDemo2 {
    public static void main(String[] args) {
        print1();
        print2();
    }

    private static void print2() {
        String s = "fafafafa";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }

    private static void print1() {
        String s = "fafafafa";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }
}
