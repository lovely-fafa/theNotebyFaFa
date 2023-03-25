package com.itheima.a04udpdemo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceiveMessageDemo1 {
    public static void main(String[] args) throws IOException {

        MulticastSocket ms = new MulticastSocket(10000);

        // 将当前本机 添加到 224.0.0.1 的这一组
        InetAddress address = InetAddress.getByName("224.0.0.3");
        ms.joinGroup(address);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        ms.receive(dp);

        byte[] data = dp.getData();
        int length = dp.getLength();
        String ip = dp.getAddress().getHostAddress();
        String name = dp.getAddress().getHostName();
        System.out.println("ip为:" + ip + ",主机名为:" + name + "的人，发送了数据:" + new String(data, 0, length));
    }
}
