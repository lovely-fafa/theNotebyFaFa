package com.itheima.test;

import java.util.Random;

public class Test7 {
    public static void main(String[] args) {

        char[] chs = initArray();
        System.out.println(chs);
        String s = getCheckCode(chs);
        System.out.println(s);
    }

    private static String getCheckCode(char[] chs) {
        Random r = new Random();
        String s = "";
        for (int i = 1; i <= 5; i++) {
            s += chs[r.nextInt(chs.length)];
        }
        return s;
    }

    private static char[] initArray() {
        char[] chs = new char[26 +26 +10];

        int index = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            chs[index] = i;
            index ++;
        }
        for (char i = 'a'; i <= 'z'; i++) {
            chs[index] = i;
            index ++;
        }
        for (char i = '0'; i <= '9'; i++) {
            chs[index] = i;
            index ++;
        }
        return chs;
    }
}
