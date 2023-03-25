package com.itheima.test;

import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

//        method1();  // 38.145秒
//        method2();  // 0.014秒
//        method3();  // 21.321秒
        method4();  // 1.716秒

        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0 + "秒");
    }

    public static void method1() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\绿色软件_不可多得的安装包\\安装包\\setupproplus2019retail.x86.zh-cn安装包.exe");
        FileOutputStream fos = new FileOutputStream("E:\\绿色软件_不可多得的安装包\\安装包\\学习java的复制粘贴时的文件.iso");

        int b;
        while ((b = fis.read()) != -1){
            fos.write(b);
        }

        fos.close();
        fis.close();
    }

    public static void method2() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\绿色软件_不可多得的安装包\\安装包\\setupproplus2019retail.x86.zh-cn安装包.exe");
        FileOutputStream fos = new FileOutputStream("E:\\绿色软件_不可多得的安装包\\安装包\\学习java的复制粘贴时的文件.iso");

        byte[] bytes = new byte[8192];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        fos.close();
        fis.close();
    }

    public static void method3() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\绿色软件_不可多得的安装包\\安装包\\ideaIU-2022.3.1.exe"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\绿色软件_不可多得的安装包\\安装包\\学习java的复制粘贴时的文件.iso"));

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }

        bos.close();
        bis.close();
    }

    public static void method4() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\绿色软件_不可多得的安装包\\安装包\\ideaIU-2022.3.1.exe"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\绿色软件_不可多得的安装包\\安装包\\学习java的复制粘贴时的文件.iso"));

        byte[] bytes = new byte[8192];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bos.close();
        bis.close();
    }
}
