package com.itheima.a04mycharstream1;

import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("day05-code\\aaa\\a.txt");

        char[] chars = new char[2];
        int len;

        // 读取数据 解码 强转
        while ((len = fr.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }

        fr.close();
    }
}
