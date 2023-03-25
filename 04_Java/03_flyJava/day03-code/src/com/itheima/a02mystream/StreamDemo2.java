package com.itheima.a02mystream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        // 1. 单列集合
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "a", "b", "C", "a", "b", "C", "a", "b", "C");
        Stream<String> stream1 = list1.stream();
        stream1.forEach(s -> System.out.println(s));
    }
}
