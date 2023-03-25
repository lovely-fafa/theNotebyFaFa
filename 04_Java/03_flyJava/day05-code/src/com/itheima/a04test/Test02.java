package com.itheima.a04test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("day05-code\\aaa\\ency_xyn_pic.jpg");
        FileOutputStream fos = new FileOutputStream("day05-code\\aaa\\decry_xyn_pic.jpg");

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b ^ 2227);
        }

        fos.close();
        fis.close();
    }
}
