package com.itheima.a05tcpdemo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // TCP 协议

        // 1. 创建 socket 对象
        // 同时回去链接服务端 如果连接不上会报错
        Socket socket = new Socket("127.0.0.1", 1000);

        // 2. 可以从连接通道获取输出流
        OutputStream os = socket.getOutputStream();
        // 写出
        os.write("焦虑啊aaa".getBytes());

        // 3. 释放资源
        os.close();
        socket.close();
    }
}
