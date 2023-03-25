package com.itheima.a02convertstream;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo2 {
    public static void main(String[] args) throws IOException {
        // liaojie();
        FileWriter fw = new FileWriter("day06-code\\cc.txt", Charset.forName("GBK"));
        fw.write("你好哇");
        fw.close();
    }

    /**
     * 了解即可 FileWriter 已经实现了
     * @throws IOException
     */
    private static void liaojie() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("day06-code\\c.txt"), "GBK");
        osw.write("您好");
        osw.close();
    }
}
