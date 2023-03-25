package com.itheima.a04mycharstream1;

import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo5 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("day05-code\\aaa\\a0.txt");

        fw.write(97);
        fw.write(98);
        fw.write(99);
        fw.write(100);


    }
}
