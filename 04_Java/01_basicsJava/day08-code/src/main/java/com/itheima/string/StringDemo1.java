package com.itheima.string;

public class StringDemo1 {
    public static void main(String[] args) {
        // public String()：创建一个空白字符串 里面不含任何内容
        String s1 = new String();
        System.out.println(s1);

        // public String(char[] chs)：根据传入的字符组 创建字符串对象
        char[] chs = {'a', 'a', 'c'};
        String s2 = new String(chs);
        System.out.println(s2);  // aac

        // public String(String original)
        String s3 = new String("abc");
        System.out.println(s3);
    }
}
