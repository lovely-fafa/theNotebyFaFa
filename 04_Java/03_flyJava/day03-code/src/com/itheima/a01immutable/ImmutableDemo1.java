package com.itheima.a01immutable;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class ImmutableDemo1 {
    public static void main(String[] args) {
        List<String> list = List.of("张三", "李四", "王五");

        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(0));

        for (String s : list) {
            System.out.println(s);
        }

        Iterator<String> it = list.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }

        // list.remove("李四");
    }
}
