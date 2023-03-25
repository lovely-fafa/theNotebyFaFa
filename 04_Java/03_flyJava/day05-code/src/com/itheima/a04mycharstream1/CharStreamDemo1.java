package com.itheima.a04mycharstream1;

import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("day05-code\\aaa\\a.txt");

        // 字符流的底层也是字节流，默认也是一个宁节一个字节的读取的。
        // 如果遇到中文就会一次读取多个，GBK 一次读两个字节，UTF-8 一次读三个字节
        // read () 细节:
        //      1.read():默认也是一个字节一个字节的读取的
        //      2.在读取之后，方法的底层还会进行解码并转成十进制。
        //          最终把这个十进制作为返回值
        //          这个十进制的数据也表示在字符集上的数字

        // 我想看到中文汉字，就是把这些十进制数据，再进行强转就可以了
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        fr.close();
    }
}
