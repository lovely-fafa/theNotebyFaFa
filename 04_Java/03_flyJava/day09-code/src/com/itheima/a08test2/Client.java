package com.itheima.a08test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 客户端: 发送一条数据，接收服务端反馈的消息并打印
        // 服务器: 接收数据并打印，再给客户端反馈消息

        Socket socket = new Socket("127.0.0.1", 10000);

        String str = "见到你很高兴";
        OutputStream os = socket.getOutputStream();
        os.write(str.getBytes());

        // 写一个结束标记
        socket.shutdownOutput();

        // 就收回复
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        socket.close();
    }
}
