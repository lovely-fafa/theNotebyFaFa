package com.itheima.a01mybufferedstream1;

import java.io.*;

public class BufferedStreamDemo1 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day06-code\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day06-code\\ab.txt"));

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }

        bos.close();
        bis.close();
    }
}
