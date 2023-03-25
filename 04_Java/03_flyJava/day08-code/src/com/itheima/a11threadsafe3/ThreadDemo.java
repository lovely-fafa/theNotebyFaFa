package com.itheima.a11threadsafe3;

public class ThreadDemo {
    public static void main(String[] args) {
        /*
            某电影院目前正在上映国产大片，共有 100 张票，而它有 3 个窗口卖票，请设计一个程序模拟该电影院卖票
         */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.setName("窗口 1");
        t2.setName("窗口 2");
        t3.setName("窗口 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
