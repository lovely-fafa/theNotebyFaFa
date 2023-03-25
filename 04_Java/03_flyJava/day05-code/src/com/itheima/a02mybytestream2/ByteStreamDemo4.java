package com.itheima.a02mybytestream2;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fls = new FileInputStream("day05-code\\src\\a.txt");

        byte[] bytes = new byte[3];

        // 一次读取多个字节数据，具体读多少，跟散组的长度有关
        // 返回值：本次读取到了多少个字节数据
        int len1 = fls.read(bytes);
        System.out.println(len1);
        String str1 = new String(bytes, 0, len1);
        System.out.println(str1);

        // 当最后读到结尾了 len 的值就是 -1
        int len2 = fls.read(bytes); // 返回值：本次读取到了多少个字节数据
        System.out.println(len2);
        // 这个地方 相当于是在往 数组 里面添加数据
        // 如果此时，文本里面读剩下的数据填不满数组 则这一次的没有填写到的数组部分的值是上一次的
        // 所以，这个地方 我们把数组转化为字符串时 根据 len 的值 把本次读到的数据转化为字符串了
        String str2 = new String(bytes, 0, len2);
        System.out.println(str2);

        fls.close();
    }
}
