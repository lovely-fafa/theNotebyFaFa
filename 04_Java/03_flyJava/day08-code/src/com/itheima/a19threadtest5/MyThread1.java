package com.itheima.a19threadtest5;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread1 extends Thread {
    ArrayList<Integer> list;

    public MyThread1(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread2.class) {
                if (list.size() == 0) {
                    break;
                } else {
                    Collections.shuffle(list);
                    Integer remove = list.remove(0);
                    System.out.println(getName() + "抽到了 " + remove);
                }
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
