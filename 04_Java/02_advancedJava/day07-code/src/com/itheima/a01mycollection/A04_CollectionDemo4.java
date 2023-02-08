package com.itheima.a01mycollection;

import java.util.ArrayList;
import java.util.Collection;

public class A04_CollectionDemo4 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");

        for (String s : coll) {
            System.out.println(s);
        }
    }
}
