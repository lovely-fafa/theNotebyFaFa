package com.itheima.a02mybytestream2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fls = new FileInputStream("D:\\大学牲\\大二上_2021_2022\\会展概论\\小组作业\\PPT\\会展概论.pdf");
        FileOutputStream fos = new FileOutputStream("day05-code\\src\\res.pdf");

        // 核心思想：边读不写
        int b;
        while ((b = fls.read()) != -1) {
            fos.write(b);
        }

        fos.close();
        fls.close();
    }
}
