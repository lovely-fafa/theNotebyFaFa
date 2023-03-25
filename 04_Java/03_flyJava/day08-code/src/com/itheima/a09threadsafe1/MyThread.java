package com.itheima.a09threadsafe1;

public class MyThread extends Thread{
    //表示这个类所有的对象，相共享 ticket
    static int ticket = 0;

    @Override
    public void run() {
        while (true) {
            // 锁对象 一定要是唯一的
            synchronized (MyThread.class) {
                if (ticket < 100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket++;
                    System.out.println(getName() + " 正在卖票第 " + ticket + " 张票！！");
                } else {
                    break;
                }
            }
        }
    }
}
