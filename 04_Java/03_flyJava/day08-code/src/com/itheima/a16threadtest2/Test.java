package com.itheima.a16threadtest2;

public class Test {
    public static void main(String[] args) {
        /*
            有100份礼品,两人同时发送，当剩下的礼品小于10份的时候则不再送出，
            利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来.
        */

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("发发");
        t2.setName("fafa");

        t1.start();
        t2.start();



    }
}
