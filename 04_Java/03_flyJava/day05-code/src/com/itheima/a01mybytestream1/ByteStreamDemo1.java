package com.itheima.a01mybytestream1;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException {
        // 1. 创建对象
        // 细节1：参数是字符中表示的路径或者是 File 对象都是可以的
        // 细节2：如果文件不存在会创建一个新的文件，但是要保证父级路径是存在的
        // 细节3：如果文件已经存在，会清空文件
        FileOutputStream fos = new FileOutputStream("day05-code\\src\\a.txt");

        // 2. 写出数据
        // 细节: write 方法的参数是整数，但是实际上写到本地文件中的是整数在 ASCII 上对应的字符 (显而易见啊 这个是字节流？是吗？)
        fos.write(97);

        // 3. 释放资源
        fos.close();
    }
}
