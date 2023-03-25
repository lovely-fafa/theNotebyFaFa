package com.itheima.a18threadtest4;

import java.util.Random;

public class MyThread1 extends Thread{
    static double money = 100;
    static int count = 3;
    static final double MIN = 0.01;  // final 修饰 是常量 所以要大写

    @Override
    public void run() {
        synchronized (MyThread1.class) {
            if (count == 0) {
                System.out.println(getName() + "没有抢到红包！");
            } else {
                double prize;
                if (count == 1) {
                    // 最后一个红包
                    prize = money;
                } else {
                    // 不是最后一次
                    Random r = new Random();
                    prize = r.nextDouble(100 - (count - 1) * MIN);
                    if (prize < MIN) {
                        prize = MIN;
                    }
                }
                // 状态修改
                count--;
                money = money - prize;
                System.out.println(getName() + "抢到了 " + prize + " 元");
            }
        }
    }
}
