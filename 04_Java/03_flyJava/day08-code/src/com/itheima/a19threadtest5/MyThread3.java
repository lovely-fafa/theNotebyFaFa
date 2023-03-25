package com.itheima.a19threadtest5;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread3 extends Thread {
    ArrayList<Integer> list;

    public MyThread3(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        ArrayList<Integer> boxList = new ArrayList<>();
        while (true) {
            synchronized (MyThread1.class) {
                if (list.size() == 0) {
                    System.out.println(boxList);
                    break;
                } else {
                    Collections.shuffle(list);
                    Integer remove = list.remove(0);
                    // System.out.println(getName() + "抽到了 " + remove);
                    boxList.add(remove);
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
