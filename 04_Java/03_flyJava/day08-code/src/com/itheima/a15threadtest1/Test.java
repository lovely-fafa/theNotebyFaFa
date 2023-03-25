package com.itheima.a15threadtest1;

import com.itheima.a15threadtest1.MyThead;

public class Test {
    /*
        一共有1000张电影票,可以在两个窗口领取,假设每次领取的时间为3000毫秒,
        要求:请用多线程模拟卖票过程并打印剩余电影票的数量
     */
    public static void main(String[] args) {
        MyThead t1 = new MyThead();
        MyThead t2 = new MyThead();

        t1.setName("窗口 1");
        t2.setName("窗口 2");

        t1.start();
        t2.start();
    }
}
