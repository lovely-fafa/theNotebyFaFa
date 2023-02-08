package com.itheima.a01mygenerics;

import java.util.ArrayList;

public class ListUtil {
    private ListUtil(){}

    /*
    *  参数一：集合
    *  参数二：要添加的元素
    * */
    public static<E> void addAll(ArrayList<E> list, E e1, E e2,E e3,E e4){
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
    }

    public void show() {
        System.out.println("阿伟...");
    }
}
