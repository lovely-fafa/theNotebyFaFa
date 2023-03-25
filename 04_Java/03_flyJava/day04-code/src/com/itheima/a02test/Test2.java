package com.itheima.a02test;

import java.io.File;

public class Test2 {
    public static void main(String[] args) {
        File file = new File("D:\\大学牲");
        boolean b = havaPDF(file);
        System.out.println(b);
    }

    /**
     * 用来找某一个文件夹中是否有 .PDF 结尾的文件
     * @param file
     * @return
     */
    public static boolean havaPDF(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".pdf")) {
                return true;
            }
        }
        return false;
    }
}
