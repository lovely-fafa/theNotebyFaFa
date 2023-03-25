package com.itheima.a06myzipstream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipStreamDemo1 {
    public static void main(String[] args) throws IOException {
        File src = new File("E:\\插来键去\\pr插件\\人工AI智能视频无损放大AE PR插件 ScaleUP v1.4.0 Win.zip");
        File dest = new File("E:\\学习java的缓存文件");

        unzip(src, dest);
    }

    public static void unzip(File src, File dest) throws IOException {
        // 创建解压缩流
        ZipInputStream zip = new ZipInputStream(new FileInputStream(src));

        ZipEntry entry;
        while ((entry = zip.getNextEntry()) != null) {
            if (entry.isDirectory()) {
                File file = new File(dest, entry.getName());
                file.mkdirs();
            } else {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(dest, entry.getName())));
                int b;
                while ((b = zip.read()) != -1) {
                    bos.write(b);
                }
                bos.close();
                zip.closeEntry();
            }
        }
        zip.close();
    }
}
