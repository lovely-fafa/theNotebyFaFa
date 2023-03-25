package com.itheima.a02myfile;

import java.io.File;

public class FileDemo2 {
    public static void main(String[] args) {
        // 1. 文件夹路径判断
        File f1 = new File("D:\\aaa\\a.txt");
        System.out.println(f1.isDirectory());

        // 2. 文件路径判断
        System.out.println(f1.isFile());

        // 3. 是否存在
        System.out.println(f1.exists());
    }
}
