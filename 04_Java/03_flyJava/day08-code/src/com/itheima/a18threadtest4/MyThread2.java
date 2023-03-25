package com.itheima.a18threadtest4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MyThread2 extends Thread{
    static BigDecimal money = BigDecimal.valueOf(100.0);
    static int count = 3;
    static final BigDecimal MIN = BigDecimal.valueOf(0.01);  // final 修饰 是常量 所以要大写

    @Override
    public void run() {
        synchronized (MyThread2.class) {
            if (count == 0) {
                System.out.println(getName() + "没有抢到红包！");
            } else {
                BigDecimal prize;
                if (count == 1) {
                    // 最后一个红包
                    prize = money;
                } else {
                    // 不是最后一次
                    Random r = new Random();
                    double bounds = money.subtract(BigDecimal.valueOf(count - 1).multiply(MIN)).doubleValue();
                    prize = BigDecimal.valueOf(r.nextDouble(bounds));

                }
                prize = prize.setScale(2, RoundingMode.HALF_UP);
                // 状态修改
                count--;
                money = money.subtract(prize);
                System.out.println(getName() + "抢到了 " + prize + " 元");
            }
        }
    }
}
