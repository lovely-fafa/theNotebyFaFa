package com.itheima.a07test1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        // 客户端: 多次发送数据
        // 服务器: 按收多次按收数据。并打印

        Socket socket = new Socket("127.0.0.1", 10000);
        OutputStream os = socket.getOutputStream();

        while (true) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if ("886".equals(str)) {
                break;
            }
            os.write(str.getBytes());
        }
        socket.close();
    }
}
