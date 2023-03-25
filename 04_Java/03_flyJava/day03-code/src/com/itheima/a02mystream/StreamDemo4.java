package com.itheima.a02mystream;

import java.util.Arrays;

public class StreamDemo4 {
    public static void main(String[] args) {
        // 基本数据类型
        int[] arr1 = {1, 2, 3, 4, 5};
        Arrays.stream(arr1).forEach(s -> System.out.println(s));

        // 引用数据类型
        String[] arr2 = {"1", "2", "3", "4", "5"};
        Arrays.stream(arr2).forEach(s -> System.out.println(s));
    }
}
