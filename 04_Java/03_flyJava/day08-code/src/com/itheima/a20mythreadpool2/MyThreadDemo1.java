package com.itheima.a20mythreadpool2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadDemo1 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,  // 核心线程数量 不能小于0
                6,  // 最大线程数量，不能小于0 最大数量 >= 核心数量
                60,  // 空闲线程最大存活时间
                TimeUnit.SECONDS,  // 时间单位
                new ArrayBlockingQueue<>(3),  // 任务队列
                Executors.defaultThreadFactory(), // 创建线程工厂
                new ThreadPoolExecutor.AbortPolicy() // 拒绝策略
        );
    }
}
