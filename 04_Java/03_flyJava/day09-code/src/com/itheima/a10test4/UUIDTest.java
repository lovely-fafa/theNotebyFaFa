package com.itheima.a10test4;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().replace("-", "");
        System.out.println(s);
    }
}
