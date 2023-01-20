package com.itheima.stringBuilder;

public class StringBuilderDemo1 {
    public static void main(String[] args) {


    }

    private static void method() {
        long start = System.currentTimeMillis();

        String s = "";
        for (int i = 0; i < 100000; i++) {
            s += i;
        }
        System.out.println(s);

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
