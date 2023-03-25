package com.itheima.a08myhutool;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        File file = FileUtil.file("D:\\", "aaa", "bbb", "c.txt");
        System.out.println(file);  // D:\aaa\bbb\c.txt

        // File f = new File("a.txt");
        // f.createNewFile();
        // 如果父级路径不存在 会报错
        // 但是 touch 就可以创建不存在我父级路径
        File touch = FileUtil.touch("D:\\aaa\\bbb\\c.txt");
        System.out.println(touch);  // D:\aaa\bbb\c.txt

        // 写到文件
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa0");
        list.add("aaa012");
        File file1 = FileUtil.writeLines(list, "D:\\aaa\\bbb\\c.txt", "UTF-8", true);
        System.out.println(file1);  // D:\aaa\bbb\c.txt

        List<String> stringList = FileUtil.readLines("E:\\程序员\\发发的笔记\\flyJava\\day06-code\\a.txt", "UTF-8");
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
