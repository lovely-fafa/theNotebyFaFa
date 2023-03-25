package com.itheima.a14waitandnotify;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo {
    public static void main(String[] args) {
        // 1. 创建阻塞队列
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        // 2. 创建线程对象 并把阻塞队列传递过去
        Cook c = new Cook(queue);
        Foodie f = new Foodie(queue);

        // 3. 启动线程
        c.start();
        f.start();
    }
}
