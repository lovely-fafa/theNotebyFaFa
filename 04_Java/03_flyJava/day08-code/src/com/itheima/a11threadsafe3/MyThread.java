package com.itheima.a11threadsafe3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread{
    //表示这个类所有的对象，相共享 ticket
    static int ticket = 0;

    //表示这个类所有的对象，相共享 ticket
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            // 加锁
            lock.lock();

            try {
                if (ticket < 100){
                    Thread.sleep(100);
                    ticket++;
                    System.out.println(getName() + " 正在卖票第 " + ticket + " 张票！！");
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                // 无论如何 代码都会执行解锁
                // 当某线程的 ticket==100 时 直接 break 跳出循环
                // 此时若不通过无论如何都会执行的 finally 使线程解锁 那么其他线程就会一直等待解锁
                lock.unlock();
            }
        }
    }
}
