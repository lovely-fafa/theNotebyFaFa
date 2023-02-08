package com.itheima.a01mycollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class A03_CollectionDemo3 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");

        // 获取迭代器对象
        // 迭代器就好比是一个箭头，默认指向集合的 0 索引处
        Iterator<String> it = coll.iterator();
        // 利用循环不断的去获取集合中的每一个元系
        while (it.hasNext()) {
            // next 方法的两件事情：获取元素并移动指针
            String str = it.next();
            System.out.println(str);
        }
    }
}
