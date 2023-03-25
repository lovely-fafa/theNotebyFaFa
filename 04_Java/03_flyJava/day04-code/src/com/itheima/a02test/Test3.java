package com.itheima.a02test;

import java.io.File;

public class Test3 {
    public static void main(String[] args) {
        for (File file : File.listRoots()) {
            findAVI(file);
        }
    }
    public static void findAVI(File src) {
        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".mp3")) {
                        System.out.println(file);
                    }
                } else {
                    findAVI(file);
                }
            }
        }
    }
}
