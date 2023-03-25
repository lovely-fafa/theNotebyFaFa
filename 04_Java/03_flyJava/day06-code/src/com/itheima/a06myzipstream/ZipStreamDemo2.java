package com.itheima.a06myzipstream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo2 {
    public static void main(String[] args) throws IOException {
        File src = new File("day06-code\\src\\com\\itheima\\test\\csb.txt");
        File dest = new File("E:\\学习java的");
        dest.mkdirs();

        toZip(src, dest);
    }

    public static void toZip(File src, File dest) throws IOException {
        // 1. 创建压缩流关联压缩对象
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dest, "a.zip")));
        // 2. 创建 ZipEntry 对象 并放入压缩包
        ZipEntry entry = new ZipEntry("a.txt");
        zos.putNextEntry(entry);

        // 3. 把 src 文件的数据写入压缩包
        FileInputStream fis = new FileInputStream(src);
        int b;
        while ((b = fis.read()) != -1) {
            zos.write(b);
        }
        fis.close();

        // 4. 释放资源
        zos.closeEntry();
        zos.close();
    }
}
