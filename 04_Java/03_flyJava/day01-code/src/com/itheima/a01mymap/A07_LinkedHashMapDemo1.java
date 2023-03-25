package com.itheima.a01mymap;

import java.util.LinkedHashMap;

public class A07_LinkedHashMapDemo1 {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("a", 789);
        lhm.put("b", 585);
        lhm.put("c", 455);

        System.out.println(lhm);
    }
}
