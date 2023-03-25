package com.itheima.a19threadtest5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    ArrayList<Integer> list;

    public MyCallable(ArrayList<Integer> list) {
        this.list = list;
    }


    @Override
    public Integer call() throws Exception {
        ArrayList<Integer> boxList = new ArrayList<>();
        while (true) {
            synchronized (MyThread1.class) {
                if (list.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + boxList);
                    break;
                } else {
                    Collections.shuffle(list);
                    Integer remove = list.remove(0);
                    // System.out.println(getName() + "抽到了 " + remove);
                    boxList.add(remove);
                }
            }

            Thread.sleep(10);

        }

        if (boxList.size() == 0) {
            return null;
        } else {
            return Collections.max(boxList);
        }
    }
}
