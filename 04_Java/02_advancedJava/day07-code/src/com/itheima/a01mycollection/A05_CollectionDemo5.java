package com.itheima.a01mycollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class A05_CollectionDemo5 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");

        // 匿名内部类实现
        /*
            for (int i = 0; modCount == expectedModCount && i < size; i++){
                action.accept(elementAt(es, i));
            }
            方法的底层是遍历这个集合 把每一次的遍历传给 accept
         */
        coll.forEach(new Consumer<String>() {
            @Override
            // s 就是依次表示集合的每个数据
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // lambda 表达式
        coll.forEach(s -> System.out.println(s));
    }
}
