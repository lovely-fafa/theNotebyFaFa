package com.itheima.a06threadmethod3;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.setName("女神");  // 非守护线程
        t2.setName("备胎");

        // 第二个线程为守护线程
        t2.setDaemon(true);

        // 当 t1 执行完毕后 t2 也会被结束
        t1.start();
        t2.start();
    }
}
