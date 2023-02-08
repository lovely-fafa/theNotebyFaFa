package com.itheima.a01mygenerics;

public class GenericsDemo2 {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        System.out.println(list);  // [aaa, bbb, ccc, null, null, null, null, null, null, null]

        MyArrayList<Integer> list1 = new MyArrayList<>();
        list1.add(123);
        list1.add(1007);
        list1.add(456);

        int i = list1.get(1);
        System.out.println(i);  // 1007
    }
}
