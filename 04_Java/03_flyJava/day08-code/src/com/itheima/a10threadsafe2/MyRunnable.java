package com.itheima.a10threadsafe2;

public class MyRunnable implements Runnable{
    // 因为 Runnable 只会被创建一次 所以没必要加 static
    int ticket = 0;
    @Override
    public void run() {
        while (true) {
            if (method()) break;
        }
    }

    private synchronized boolean method() {
        if (ticket == 100) {
            return true;
        } else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + " 在卖第 " + ticket + " 张票");
        }
        return false;
    }
}
