package com.itheima.a01mybufferedstream1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedStreamDemo4 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("day06-code\\ac.txt", true));

        bw.write("你嘴角上扬的样子，百度收不到");

        // 这样是不能跨平台的
        bw.write("\r\n");
        // 跨平台换行并换行
        bw.newLine();
        bw.write("床前明月光");

        bw.close();
    }
}
