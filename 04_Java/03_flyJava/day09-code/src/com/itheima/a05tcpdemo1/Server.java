package com.itheima.a05tcpdemo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // 1. 创建 ServerSocket 对象
        ServerSocket ss = new ServerSocket(1000);

        // 2. 监听客户端数据
        Socket socket = ss.accept();

        // 3. 获取数据
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        // 4. 释放资源
        socket.close();
        ss.close();
    }
}
