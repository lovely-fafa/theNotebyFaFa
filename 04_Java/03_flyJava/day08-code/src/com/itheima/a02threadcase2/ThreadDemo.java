package com.itheima.a02threadcase2;

public class ThreadDemo {
    public static void main(String[] args) {
        MyRun mr = new MyRun();

        // 创建线程对象
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        // 取名字
        t1.setName("线程 1");
        t2.setName("线程 2");

        // 开启线程
        t1.start();
        t2.start();
    }
}
