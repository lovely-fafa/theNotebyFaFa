package com.itheima.a02mylist;

import java.util.ArrayList;
import java.util.List;

public class A01_ListDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // 1. 添加
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list);  // [aaa, bbb, ccc]

        // 2. 删除
        String remove = list.remove(0);
        System.out.println(remove);  // aaa

        // 3. 改值
        String result = list.set(0, "qqq");
        System.out.println(result);  // bbb

        // 4. 取值
        String s = list.get(0);
        System.out.println(s);  // qqq
    }
}
