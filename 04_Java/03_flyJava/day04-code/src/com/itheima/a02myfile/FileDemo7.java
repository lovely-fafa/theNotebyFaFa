package com.itheima.a02myfile;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileDemo7 {
    public static void main(String[] args) {
        // 1. 获取盘符
        File[] arr = File.listRoots();
        System.out.println(Arrays.toString(arr));

        // 2. 获取内容（只有名字 没有路径）
        File f1 = new File("D:\\大学牲");
        String[] list = f1.list();
        for (String s : list) {
            System.out.println(s);
        }

        // 3. 文件过滤器
        String[] arr3 = f1.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".pdf");
            }
        });
        System.out.println(Arrays.toString(arr3));
    }
}
