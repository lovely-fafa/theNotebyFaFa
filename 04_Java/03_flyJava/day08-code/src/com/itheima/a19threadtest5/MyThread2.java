package com.itheima.a19threadtest5;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread2 extends Thread {
    ArrayList<Integer> list;

    // 线程 1
    ArrayList<Integer> list1 = new ArrayList<>();
    // 线程 2
    ArrayList<Integer> list2 = new ArrayList<>();

    public MyThread2(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread1.class) {
                if (list.size() == 0) {
                    if (getName().equals("窗口 1 ")) {
                        System.out.println(list1);
                    } else {
                        System.out.println(list2);
                    }
                    break;
                } else {
                    Collections.shuffle(list);
                    Integer remove = list.remove(0);
                    // System.out.println(getName() + "抽到了 " + remove);
                    if (getName().equals("窗口 1 ")) {
                        list1.add(remove);
                    } else {
                        list2.add(remove);
                    }
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
