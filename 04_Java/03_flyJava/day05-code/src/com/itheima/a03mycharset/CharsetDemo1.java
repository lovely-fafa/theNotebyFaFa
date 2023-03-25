package com.itheima.a03mycharset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharsetDemo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 1. 编码
        String str1 = "ai你哟";
        byte[] bytes1 = str1.getBytes();  // idea 默认是 utf-8
        System.out.println(Arrays.toString(bytes1));

        byte[] bytes2 = str1.getBytes("GBK");  // idea 默认是 utf-8
        System.out.println(Arrays.toString(bytes2));

        // 2. 编码
        String str2 = new String(bytes1);
        System.out.println(str2);

        String str3 = new String(bytes2, "GBK");
        System.out.println(str3);
    }
}
