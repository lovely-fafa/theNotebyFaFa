package com.itheima.a04mycharstream1;

import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("day05-code\\aaa\\a0.txt");

        // 1. 写一个字符
        fw.write(25105);

        // 2. 写一个字符串
        fw.write("huo下午茶呀！");

        // 3. 写一个字符串的一部分
        fw.write("huo下午茶呀！", 1, 3);

        // 4. 写出一个字符数组
        char[] chars = {'a', 'b', '我'};
        fw.write(chars);

        // 5. 写出一个字符数组的一部分
        fw.write(chars, 2, 1);

        fw.close();
    }
}
