package com.itheima.a07threadmethod4;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "@" + i);

            // 出让当前 CPU 的执行权
            // 本次线程执行到这一行代码后 会让出 CPU
            Thread.yield();
        }
    }
}
