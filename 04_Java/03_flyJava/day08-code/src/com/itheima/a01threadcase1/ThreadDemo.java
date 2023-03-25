package com.itheima.a01threadcase1;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // 取名字
        t1.setName("线程 1");
        t2.setName("线程 2");

        t1.start();
        t2.start();
    }
}
