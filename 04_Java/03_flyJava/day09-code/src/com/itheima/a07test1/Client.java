package com.itheima.a07test1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 客户端: 多次发送数据
        // 服务器: 按收多次按收数据。并打印
        ServerSocket ss = new ServerSocket(10000);

        Socket accept = ss.accept();
        InputStream is = accept.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);

        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        ss.close();
    }
}
