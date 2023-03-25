package com.itheima.a02test;

import java.io.File;

public class Test4 {
    public static void main(String[] args) {
        delete(new File("E:\\程序员\\发发的笔记\\flyJava\\day04-code\\aaa"));
    }

    /**
     * 输出 src 文件夹
     * @param src
     */
    public static void delete(File src) {
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            } else {
                delete(file);
            }
        }
        src.delete();
    }
}
