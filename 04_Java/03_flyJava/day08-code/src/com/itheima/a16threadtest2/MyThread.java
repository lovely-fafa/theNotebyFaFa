package com.itheima.a16threadtest2;

public class MyThread extends Thread{
    static int count = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (count < 10) {
                    System.out.println(getName() + "没有礼品了！！！");
                    break;
                } else {
                    System.out.println(getName() + "拿到了礼物，还剩 " + count + " 个！！");
                    count--;
                }
            }
        }
    }
}
