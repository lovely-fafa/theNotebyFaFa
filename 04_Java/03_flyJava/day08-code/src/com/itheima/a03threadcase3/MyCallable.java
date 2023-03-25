package com.itheima.a03threadcase3;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 开启这个线程 计算 1 - 100 的和
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum = sum + i;
        }

        return sum;
    }
}
