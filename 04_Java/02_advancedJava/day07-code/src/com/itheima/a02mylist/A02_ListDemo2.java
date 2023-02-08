package com.itheima.a02mylist;

import java.util.ArrayList;
import java.util.List;

public class A02_ListDemo2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // 因为在调用方法的时候，如果方法出现了重载现象
        // 优先调用，实参跟形参类型一致的那个方法。(所以 remove 不会自动装箱)
        list.remove(1);  // 删的是索引
        System.out.println(list);

        // 手动装箱
        Integer i = Integer.valueOf(1);  // [1, 3, 4]
        list.remove(i);

        System.out.println(list);  // [3, 4]
    }
}
