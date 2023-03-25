package com.itheima.a15threadtest1;

public class MyThead extends Thread {
    static int ticket = 1000;

    @Override
    public void run() {
        while (true) {
            synchronized (MyThead.class) {
                if (ticket == 0) {
                    System.out.println(getName() + " 卖完了！！！");
                    break;
                } else {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(getName() + " 买了一张票，还剩 " + ticket + " 张票！");
                    ticket--;
                }
            }
        }
    }
}
