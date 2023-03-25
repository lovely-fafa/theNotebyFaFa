package com.itheima.a18threadtest4;

public class Test {
    /*
    微信中的抢红包也用到了多线程。
    假设：100块，分成了3个包，现在有5个人去抢。
    其中，红包是共享数据。
    5个人是5条线程。
    打印结果如下：
        XXX抢到了XXX元
        XXX抢到了XXX元
        XXX抢到了XXX元
        XXX没抢到
        XXX没抢到
    */
    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2();
        MyThread2 t2 = new MyThread2();
        MyThread2 t3 = new MyThread2();
        MyThread2 t4 = new MyThread2();
        MyThread2 t5 = new MyThread2();

        t1.setName("小A");
        t2.setName("小QQ");
        t3.setName("小哈哈");
        t4.setName("小诗诗");
        t5.setName("小丹丹");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
