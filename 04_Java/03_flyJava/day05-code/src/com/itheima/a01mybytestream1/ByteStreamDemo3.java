package com.itheima.a01mybytestream1;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("day05-code\\src\\a.txt");

        // 1. 换行写
        String str = "fafa";
        byte[] arr = str.getBytes();
        fos.write(arr);

        fos.write("\r\n".getBytes());
        fos.write("666".getBytes());

        fos.write("\r\nfafafafa\r\n666".getBytes());  // 所以为什么不一步到位...

        fos.close();

        // 2. 续写
        // append 为 true
        FileOutputStream fos1 = new FileOutputStream("day05-code\\src\\a.txt", true);
        fos1.write("ahhhh".getBytes());
        fos1.close();
    }
}
