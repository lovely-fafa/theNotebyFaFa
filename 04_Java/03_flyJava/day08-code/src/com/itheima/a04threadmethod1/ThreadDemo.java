package com.itheima.a04threadmethod1;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        /*
            细节：
                1、如果我们没有给线程设置名字，线程也是有默认的名字的格式: Thread-X(X序号，从 0 开始的)
                2、如果我们要给线程设置名字，可以用 set 方法进行设置，也可以构造方法设置 但是继承 Thread 类时 需要重写构造
         */

        MyThread t1 = new MyThread("坦克");
        MyThread t2 = new MyThread("飞机");

        // todo: 有参构造和 setName 都设置了 那会怎么样捏
        t1.setName("线程 1 ");
        t1.setName("线程 2 ");

        t1.start();  // Thread-1 HelloWorld
        t2.start();  // Thread-0 HelloWorld

        Thread t = Thread.currentThread();
        /*
            细节
            获取当前线程的对象
            当 JVM 虚拟机启动之后，会自动地启动多条线程
            其中有一条线程就叫做 main 线程
            他的作用就是去调用 main 方法，并执行里面的代码
            在以前，我们写的所有的代码，其实都是运行在 main 线程当中
         */
        System.out.println(t.getName());  // main

        System.out.println("11111111111");
        Thread.sleep(5000);
        // 1、哪条线程执行到这个方法，那么哪条线程就会在这里停留对应的时间
        // 2、方法的参数：就表示睡眠的时间，单位毫秒 1秒 = 1000毫秒
        // 3、当时间到了之后，线程会自动的醒米，继续执行下面的其他代码
        System.out.println("22222");
    }
}
