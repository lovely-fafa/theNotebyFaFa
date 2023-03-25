package com.itheima.a03udpdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10086);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        while (true) {
            ds.receive(dp);

            String hostAddress = dp.getAddress().getHostAddress();
            System.out.println("接收到数据来自 " + hostAddress + " 的数据为：" + new String(bytes, 0, dp.getLength()));
        }
    }
}
