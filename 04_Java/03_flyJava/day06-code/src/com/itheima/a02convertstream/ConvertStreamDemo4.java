package com.itheima.a02convertstream;

import java.io.*;

public class ConvertStreamDemo4 {
    public static void main(String[] args) throws IOException {
        // 利用字节流读取文件中的数据，每次读一整行，而且不能出现乱码
        FileInputStream fis = new FileInputStream("day06-code\\a.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br0 = new BufferedReader(isr);

        String str = br0.readLine();
        System.out.println(str);
        br0.close();

        // 一步到位
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("day06-code\\a.txt")));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
