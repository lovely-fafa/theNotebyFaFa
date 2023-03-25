package com.itheima.a19threadtest5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);

        MyCallable mc = new MyCallable(list);

        FutureTask ft1 = new FutureTask<>(mc);
        FutureTask ft2 = new FutureTask<>(mc);

        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);

        t1.setName("抽奖箱 1 ");
        t2.setName("抽奖箱 2 ");

        t1.start();
        t2.start();

        Integer max1 = (Integer) ft1.get();
        Integer max2 = (Integer) ft2.get();
        System.out.println(max1);
        System.out.println(max2);
    }
}
