package com.itheima.a02myfile;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileDemo8 {
    public static void main(String[] args) {
        File f = new File("D:\\大学牲");

        File[] files1 = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".pdf");
            }
        });
        for (File file : files1) {
            System.out.println(file);
        }

        System.out.println("----------------------------");

        File[] files2 = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".pdf");
            }
        });
        for (File file : files2) {
            System.out.println(file);
        }
    }
}
