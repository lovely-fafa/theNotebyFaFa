package com.itheima.a08threadmethod5;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.setName("土豆");
        t.start();

        // 把 t 这个线程插入到当前线程之前
        // t：土豆线程
        // 当前线程：main 线程
        t.join();

        // 会在 main 线程当中执行
        for (int i = 0; i < 10; i++) {
            System.out.println("main 线程@" + i);
        }
    }
}
