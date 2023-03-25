package com.itheima.a03threadcase3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建 MyCallable 的对象(表示多线程要执行的任务)
        MyCallable mc = new MyCallable();
        // 创建 FutureTask 的对象(作用管理多线程运行的结果)
        FutureTask<Integer> ft = new FutureTask<>(mc);
        // 创建线程的对象
        Thread t = new Thread(ft);
        // 启动线程
        t.start();
        Integer result = ft.get();
        System.out.println(result);
    }
}
