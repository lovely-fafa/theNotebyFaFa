package com.itheima.a20mythreadpool2;

public class MyThreadDemo2 {
    public static void main(String[] args) {
        // 向 java 虚拟机返回可用处理器的数目
        int runtime = Runtime.getRuntime().availableProcessors();
        System.out.println(runtime);
    }
}
