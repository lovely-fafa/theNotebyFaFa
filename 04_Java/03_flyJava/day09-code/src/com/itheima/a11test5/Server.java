package com.itheima.a11test5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws IOException {
        // 客户端:将本地文件上传到服务器。接收服务器的反馈。
        // 服务器:接收客户端上传的文件，上传完毕之后给出反馈。

        ServerSocket ss = new ServerSocket(10000);

        while (true) {
            Socket socket = ss.accept();

            // 开启一个线程
            new Thread(new MyRunnable(socket)).start();

        }

    }
}
