package com.itheima.stringBuilder;

public class StringBuilderDemo2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("fafa");
        sb.append(true);
        sb.append(123);

        System.out.println(sb);  // fafatrue123
    }
}
