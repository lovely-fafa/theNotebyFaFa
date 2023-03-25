package com.itheima.a17threadtest3;

public class MyRunnable implements Runnable {

    int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (MyRunnable.class) {
                if (num == 1001) {
                    break;
                } else {
                    if (num % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "得到奇数 " + num);
                    }
                    num++;
                }
            }
        }
    }
}
