package com.itheima.a04udpdemo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        MulticastSocket ms = new MulticastSocket();  // 组播

        String s = "你好呀";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("224.0.0.3");  // 组播地址
        int port = 10000;

        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

        ms.send(dp);
    }
}
