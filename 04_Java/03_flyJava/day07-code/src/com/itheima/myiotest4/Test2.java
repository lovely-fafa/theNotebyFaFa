package com.itheima.myiotest4;

import java.io.*;
import java.util.Properties;

public class Test2 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();

        prop.put("aaa", "111");
        prop.put("a0aa", "111");
        prop.put("aa0a", "111");
        prop.put("0aaa", "111");

        FileOutputStream fos = new FileOutputStream("day07-code\\src\\com\\itheima\\myiotest4\\a.properties");
        prop.store(fos, "test");
    }
}
