package com.itheima.a01InetAddressDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyInetAddressDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address1 = InetAddress.getByName("127.0.0.1");
        System.out.println(address1);
        InetAddress address2 = InetAddress.getByName("DESKTOP-G5QH31C");
        System.out.println(address2);

        // 1. 获取主机名
        String hostName = address2.getHostName();
        System.out.println(hostName);

        // 1. 获取 ip 地址
        String address = address2.getHostAddress();  // DESKTOP-G5QH31C
        System.out.println(address);  // 192.168.174.1
    }
}
