package com.itheima.a04threadmethod1;

public class MyThread extends Thread{

    // Thread 构造方法 是可以传 线程的名字
    // 但是 介个地方是继承的 是不会继承父类的构造方法 所以我们要


    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "@" + i);
        }
    }
}
