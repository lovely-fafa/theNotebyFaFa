package com.itheima.a01mybytestream1;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("day05-code\\src\\b.txt");

        // 1. 第一种
        fos.write(97);
        fos.write(98);

        // 2. 第二种：一次写一个字节数组
        byte[] arr1 = {11, 22, 33};
        fos.write(arr1);

        // 3. 第三种：一次写一个字节数组的部分数据
        // 参数 1：数组
        // 参数 2：起始索引
        // 参数 1：个数
        byte[] arr2 = {97, 98, 99, 100};
        fos.write(arr2, 1, 2);

        fos.close();
    }
}
