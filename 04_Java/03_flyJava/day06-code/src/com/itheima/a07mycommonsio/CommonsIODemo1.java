package com.itheima.a07mycommonsio;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonsIODemo1 {
    public static void main(String[] args) throws IOException {
        File src = new File("day06-code\\a.txt");
        File dest = new File("day06-code\\aaaa.txt");

        // 1. 复制粘贴文件
        FileUtils.copyFile(src, dest);

        // 2. 拷贝文件夹
        // 2.1 拷贝文件夹里面的
        FileUtils.copyDirectory(new File("E:\\学习java的缓存文件"), new File("E:\\学习java的"));
        // 2.2 拷贝整个文件夹
        FileUtils.copyDirectoryToDirectory(new File("E:\\学习java的缓存文件"), new File("E:\\学习java的"));

        // 3. 删除文件夹
        FileUtils.delete(new File("E:\\学习java的\\学习java的缓存文件"));

        // 3. 清空文件夹
        FileUtils.cleanDirectory(new File("E:\\学习java的\\学习java的缓存文件"));
    }
}
