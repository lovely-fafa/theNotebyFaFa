package com.itheima.test;

import java.io.*;

public class Test03 {
    public static void main(String[] args) throws IOException {
        File file = new File("day06-code\\src\\com\\itheima\\test\\count.txt");
        if (!file.exists()) {
            BufferedWriter bw = new BufferedWriter(new FileWriter("day06-code\\src\\com\\itheima\\test\\count.txt"));
            bw.write("0");
            bw.close();
        }


        BufferedReader br = new BufferedReader(new FileReader("day06-code\\src\\com\\itheima\\test\\count.txt"));
        int count = Integer.parseInt(br.readLine());
        count++;
        br.close();

        if (count <= 3) {
            System.out.println("欢迎使用本软件，第" + count + "次使用...");
            BufferedWriter bw = new BufferedWriter(new FileWriter("day06-code\\src\\com\\itheima\\test\\count.txt"));
            bw.write(count + "");
            bw.close();
        } else {
            System.out.println("本软件只能免费使用3次,欢迎您注会员后维续使用~");
        }
    }
}
