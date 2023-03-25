package com.itheima.a01mymap;

import java.util.ArrayList;
import java.util.Collections;

public class A13_CollectionsDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, "abxc", "ac", "abc", "123");
        System.out.println(list);  // [abxc, ac, abc, 123]

        Collections.shuffle(list);
        System.out.println(list);  // [ac, abxc, abc, 123]
    }
}
