package com.itheima.a01mygenerics;

public class GenericsDemo4 {
    public static void main(String[] args) {
        // 方式1：实现类给出具体类型
        MyArrayList2 list = new MyArrayList2();
        list.add("aaa");
        System.out.println(list);

        // 方式2：实现类延续泛型，创建对象时再有定
        MyArrayList3<String> list3 = new MyArrayList3();
        list3.add("aaa");
        list3.add("bbb");
        System.out.println(list3);
    }
}
