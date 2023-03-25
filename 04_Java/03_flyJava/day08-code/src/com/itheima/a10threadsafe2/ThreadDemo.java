package com.itheima.a10threadsafe2;

import com.itheima.a09threadsafe1.MyThread;

public class ThreadDemo {
    public static void main(String[] args) {
        /*
            某电影院目前正在上映国产大片，共有 100 张票，而它有 3 个窗口卖票，请设计一个程序模拟该电影院卖票
         */
        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        Thread t3 = new Thread(mr);

        t1.setName("窗口 1");
        t2.setName("窗口 2");
        t3.setName("窗口 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
