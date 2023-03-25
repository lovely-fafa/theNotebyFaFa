package com.itheima.a02mybytestream2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo6 {
    public static void main(String[] args) {

        // 为什么要这样
        // 因为 直接写在 try 里面 变量就会只存在在 try 这个大括号里面 catch 就拿不到
        // 但是又不能在外面直接定义 因为有可能会编译时异常 放在外面就 try 不到了
        FileInputStream fls = null;
        FileOutputStream fos = null;

        try {
            fls = new FileInputStream("D:\\百度网盘\\学习OpenCV 3 中文版.zip");
            fos = new FileOutputStream("D:\\百度网盘\\学习OpenCV 3 中文版2.zip");

            int len;
            byte[] bytes = new byte[1024 * 1024 * 5];
            while ((len = fls.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            // 有可能在创建 FileOutputStream 对象时出现异常
            // 会被上面的 try 捕获
            // 但是 此时 fos 就是 null 了所以我们要先判断 fos 是不是 null
            // fos 不是 null 我们才要把他 close 掉
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (fls != null) {
                try {
                    fls.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
