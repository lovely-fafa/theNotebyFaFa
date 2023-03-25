package com.itheima.a11test5;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 客户端:将本地文件上传到服务器。接收服务器的反馈。
        // 服务器:接收客户端上传的文件，上传完毕之后给出反馈。

        Socket socket = new Socket("127.0.0.1", 10000);

        // 读取本地文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day09-code\\clientdir\\铁栏杆.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        // 结束标记
        socket.shutdownOutput();

        // 回写
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // System.out.println(br.readLine());

        // 释放资源
        socket.close();
    }
}
