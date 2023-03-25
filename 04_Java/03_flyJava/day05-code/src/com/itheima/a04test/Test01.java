package com.itheima.a04test;

import java.io.*;

public class Test01 {
    public static void main(String[] args) throws IOException {

        File src = new File("D:\\大学牲\\兼职鸭");
        File dest = new File("D:\\大学牲\\兼职鸭2");
        
        copyDir(src, dest);

    }

    private static void copyDir(File src, File dest) throws IOException {

        dest.mkdirs();

        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    FileInputStream fls = new FileInputStream(file);
                    FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));

                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = fls.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                    }

                    fos.close();
                    fls.close();
                } else {
                    copyDir(file, new File(dest, file.getName()));
                }
            }
        }
    }
}
