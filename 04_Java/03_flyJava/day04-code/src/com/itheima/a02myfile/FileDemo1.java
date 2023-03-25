package com.itheima.a02myfile;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        // 1. 字符串变成 File 对象
        String str = "C\\User\\Desktop\\a.txt";
        File f1 = new File(str);
        System.out.println(f1);

        // 2. 拼接为 File 对象
        String parent = "C\\User\\Desktop";
        String child = "a.txt";
        File f2 = new File(parent, child);
        System.out.println(f2);

        // 3. File 对象与字符串拼接
        File f3 = new File("C\\User\\Desktop");
        File f4 = new File(f3, "a.txt");
        System.out.println(f4);
    }
}
