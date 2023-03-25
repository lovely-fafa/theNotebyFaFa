package com.itheima.a02mybytestream2;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fls = new FileInputStream("day05-code\\src\\a.txt");

        int b;
        // 这比较复杂捏
        while ((b = fls.read()) != -1) {
            System.out.println((char) b);
        }

        fls.close();
    }
}
