package com.itheima.a13waitandnotify;

public class Foodie extends Thread{
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    // 核心的业务逻辑
                    // 判断座子上是否有面条
                    if (Desk.foodFlag == 0) {
                        // 等待
                        try {
                            Desk.lock.wait();  // 当前线程与锁绑定
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // 修改状态
                        Desk.count--;
                        // 有面条 吃
                        System.out.println("正在吃面条 还能再吃 " + Desk.count + " 碗！！！");
                        // 唤醒这把锁的所有线程
                        Desk.lock.notifyAll();
                        // 修改状态
                        Desk.foodFlag = 0;
                    }
                }
            }
        }
    }
}
