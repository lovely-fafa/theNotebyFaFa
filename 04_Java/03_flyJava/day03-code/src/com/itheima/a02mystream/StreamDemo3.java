package com.itheima.a02mystream;

import java.util.HashMap;

public class StreamDemo3 {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("张三", "南京");
        hm.put("李四", "北京");
        hm.put("王五", "上海");
        hm.put("赵六", "北京");

        // 1. 获取 stream 的第一种方法
        hm.keySet().stream().forEach(s -> System.out.println(s));

        // 2. 获取 stream 的第二种方法
        hm.entrySet().stream().forEach(s -> System.out.println(s));
    }
}
