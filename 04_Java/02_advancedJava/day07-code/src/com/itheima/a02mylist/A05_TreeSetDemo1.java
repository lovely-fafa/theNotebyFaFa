package com.itheima.a02mylist;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.function.Consumer;

public class A05_TreeSetDemo1 {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(3);
        ts.add(4);
        ts.add(1);
        ts.add(2);
        ts.add(5);

        System.out.println(ts);

        // 迭代器遍历
        Iterator<Integer> it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 增强 for
        for (Integer t : ts) {
            System.out.println(t);
        }

        // lambda
        ts.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        });

        ts.forEach(i -> System.out.println(i));
    }
}
