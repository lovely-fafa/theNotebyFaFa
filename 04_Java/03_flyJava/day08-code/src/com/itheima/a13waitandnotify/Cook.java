package com.itheima.a13waitandnotify;

public class Cook extends Thread{
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    if (Desk.foodFlag == 1) {
                        // 有食物 等待
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // 没有食物
                        System.out.println("做了一碗面条");
                        // 修改状态
                        Desk.foodFlag = 1;
                        // 唤醒
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
