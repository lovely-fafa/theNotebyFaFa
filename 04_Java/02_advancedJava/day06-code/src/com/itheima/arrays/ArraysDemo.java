package com.itheima.arrays;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr1 = {11, 22, 33, 44, 55};
        int[] arr2 = {11, 22, 33, 44, 550};

        System.out.println(Arrays.toString(arr1));  // [11, 22, 3, 44, 55]
        System.out.println(Arrays.equals(arr1, arr2));  // false
        System.out.println(Arrays.binarySearch(arr1, 44));  // 3

        int[] arr3 = {22, 11, 55, 44, 33};
        System.out.println(Arrays.binarySearch(arr3, 11));  // -1 未排序会报错

        Arrays.sort(arr3);
        // todo: 学了红黑树再补充
        System.out.println(Arrays.toString(arr3));  // [11, 22, 33, 44, 55]
    }
}
