package com.itheima.a02mystream;

import java.util.stream.Stream;

public class StreamDemo5 {
    public static void main(String[] args) {
        Stream.of(1, 2, 5, 6, 8).forEach(s -> System.out.println(s));
    }
}
