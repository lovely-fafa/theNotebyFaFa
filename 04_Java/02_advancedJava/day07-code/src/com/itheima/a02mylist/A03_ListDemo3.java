package com.itheima.a02mylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class A03_ListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");

        // 1. 迭代器
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 2. 增强 for
        for (String s : list) {
            System.out.println(s);
        }

        // 3. lambda
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        list.forEach(s -> System.out.println(s));

        // 4. 普通 for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 5. 列表迭代器
        // 获取列表迭代器对象
        ListIterator<String> it1 = list.listIterator();
        while (it1.hasNext()) {
            String str = it1.next();
            System.out.println(str);

            // 提供了添加的方法
            if ("aaa".equals(str)) {
                it1.add("qqq");
            }

        }
        System.out.println(list);  // [aaa, qqq, bbb, ccc, ddd]
    }
}
