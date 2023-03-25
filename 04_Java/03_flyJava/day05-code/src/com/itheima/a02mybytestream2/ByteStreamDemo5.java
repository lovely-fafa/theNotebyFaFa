package com.itheima.a02mybytestream2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo5 {
    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        FileInputStream fls = new FileInputStream("D:\\百度网盘\\学习OpenCV 3 中文版.zip");
        FileOutputStream fos = new FileOutputStream("D:\\百度网盘\\学习OpenCV 3 中文版2.zip");

        int len;
        byte[] bytes = new byte[1024 * 1024 * 5];
        while ((len = fls.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        fos.close();
        fls.close();

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
