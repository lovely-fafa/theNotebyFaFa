package com.itheima.a08test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // 客户端: 发送一条数据，接收服务端反馈的消息并打印
        // 服务器: 接收数据并打印，再给客户端反馈消息

        ServerSocket ss = new ServerSocket(10000);

        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        // 回复数据
        OutputStream os = socket.getOutputStream();
        os.write("到底有多开心捏".getBytes());

        socket.close();
        ss.close();
    }
}
