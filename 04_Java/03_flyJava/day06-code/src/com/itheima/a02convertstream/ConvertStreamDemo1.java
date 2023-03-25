package com.itheima.a02convertstream;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class ConvertStreamDemo1 {
    public static void main(String[] args) throws IOException {
        // liaojie();

        FileReader fr = new FileReader("day06-code\\gbkFile.txt", Charset.forName("GBK"));
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        fr.close();

    }

    /**
     * 了解即可 FileReader 已经实现了
     * @throws IOException
     */
    private static void liaojie() throws IOException {
        // 1. 创建对象并指定编码
        InputStreamReader isr = new InputStreamReader(new FileInputStream("day06-code\\gbkFile.txt"), "GBK");
        // 2. 读取数据
        int ch;
        while ((ch = isr.read()) != -1) {
            System.out.print((char) ch);
        }
        // 3. 释放资源
        isr.close();
    }
}
