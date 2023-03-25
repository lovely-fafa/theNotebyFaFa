package com.itheima.a01mymap;

import java.util.Comparator;
import java.util.TreeMap;

public class A08_TreeMapDemo1 {
    /*
        降序排列
     */
    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        tm.put(1, "奥利奥");
        tm.put(2, "康师傅");
        tm.put(4, "六个核桃");
        tm.put(5, "可口可乐");
        tm.put(3, "雪碧");

        System.out.println(tm);  // {5=可口可乐, 4=六个核桃, 3=雪碧, 2=康师傅, 1=奥利奥}
    }
}
