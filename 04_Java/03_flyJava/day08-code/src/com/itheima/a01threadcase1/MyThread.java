package com.itheima.a01threadcase1;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " HelloWorld");
        }
    }
}
