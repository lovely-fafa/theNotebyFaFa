package com.itheima.a02myfile;

import java.io.File;

public class FileDemo6 {
    public static void main(String[] args) {
        File f = new File("D:\\大学牲");
        File[] files = f.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
}
