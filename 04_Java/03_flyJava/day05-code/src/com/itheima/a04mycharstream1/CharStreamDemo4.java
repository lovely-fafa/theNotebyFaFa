package com.itheima.a04mycharstream1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo4 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("day05-code\\aaa\\a0.txt");

        // 这个地方 把文件的 8192 字节读到缓冲区
        // 并且这个地方会返回第一个字符
        fr.read();

        // 写这个文件 此时会清空该文件
        // 但是此时缓冲区仍有数据！
        FileWriter fw = new FileWriter("day05-code\\aaa\\a0.txt");

        int b;
        while ((b = fr.read()) != -1) {
            // 输出本次缓冲区的 8191 个字节的数据（因为第一个字节的已经在 14 行输出了）
            // 但是由于文件清空 所以接下来也不会有第一次缓冲区没得完的数据的输出了
            System.out.println((char) b);
        }

        fw.close();
        fr.close();
    }
}
