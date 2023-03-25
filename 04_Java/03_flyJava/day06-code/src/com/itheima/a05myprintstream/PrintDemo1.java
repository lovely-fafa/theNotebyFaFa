package com.itheima.a05myprintstream;

import java.io.*;
import java.nio.charset.Charset;

public class PrintDemo1 {
    public static void main(String[] args) throws IOException {
        // 1. 创建字节打印流对象
        PrintStream ps = new PrintStream(new FileOutputStream("day06-code\\f.txt"), true, Charset.forName("UTF-8"));
        // 2. 写入数据
        ps.println(97);  // 写出 + 自动刷新 + 自动换行
        ps.println(true);
        ps.printf("%s爱上了%s", "阿珍", "阿强");
        // 3. 释放资源
        ps.close();
    }
}
