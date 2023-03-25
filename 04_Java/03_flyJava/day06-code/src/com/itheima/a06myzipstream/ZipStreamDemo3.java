package com.itheima.a06myzipstream;

import javax.swing.*;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo3 {
    /*
        介个代码是我琢磨出来的 应该是对的叭
     */
    public static void main(String[] args) throws IOException {
        File src = new File("farmerandlord");
        File dest = new File("E:\\学习java的");

        // 为什么要写到外面捏 因为多级文件夹需要用递归 而创建压缩包流只需要一次捏
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dest, src.getName() + ".zip")));
        toZip(src, zos);
        zos.close();
    }

    public static void toZip(File src, ZipOutputStream zos) throws IOException {
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                ZipEntry entry = new ZipEntry(file.getPath());
                zos.putNextEntry(entry);
                FileInputStream fis = new FileInputStream(file);
                int b;
                while ((b = fis.read()) != -1) {
                    zos.write(b);
                }
                fis.close();
                zos.closeEntry();
            } else {
                toZip(file, zos);
            }
        }
    }
}
