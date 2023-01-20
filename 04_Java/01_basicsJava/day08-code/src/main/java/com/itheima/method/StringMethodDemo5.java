package com.itheima.method;

public class StringMethodDemo5 {
    public static void main(String[] args) {
        String s = "192.168.2.2";
        String[] sArr = s.split("\\.");
        for (int i = 0; i < sArr.length; i++) {
            System.out.println(sArr[i]);
        }
    }
}
