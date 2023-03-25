package com.itheima.myiotest4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test3 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("day07-code\\src\\com\\itheima\\myiotest4\\a.properties");
        prop.load(fis);
        fis.close();

        System.out.println(prop);
    }
}
