package com.itheima.regex;

public class RegexDemo {
    public static void main(String[] args) {
        String qqRegex = "[1-9]\\d{4,11}";
        System.out.println("123456".matches(qqRegex));

        String telRegex = "1[3-9]\\d{9}";
        System.out.println("13619088888".matches(telRegex));

        String emailRegex = "\\w+@[\\w&&[^_]]+(\\.[a-z]{2,3})+";
        System.out.println("13619088888@163.com".matches(emailRegex));
    }
}
