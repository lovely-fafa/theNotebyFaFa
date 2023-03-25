package com.itheima.a02mybytestream2;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException {
        // 1. 创建对象
        // 细节1：如果文件不存在 直接报错
        FileInputStream fis = new FileInputStream("day05-code\\src\\a.txt");

        // 2. 读数据
        // 细节1：一次读一个字节 读出来的数据是 ASCLL 上对应的数据
        // 细节2：读到文件末尾，read 返回的是 -1
        int b1 = fis.read();
        System.out.println((char) b1);

        int b2 = fis.read();
        System.out.println(b2);

        int b3 = fis.read();
        System.out.println(b3);

        int b4 = fis.read();
        System.out.println(b4);

        fis.close();
    }
}
