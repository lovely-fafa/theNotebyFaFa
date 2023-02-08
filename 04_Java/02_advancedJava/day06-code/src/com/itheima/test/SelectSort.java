package com.itheima.test;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {11, 520, 55, 152, 54};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tem = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tem;
                }
            }
        }
        System.out.println(Arrays.toString(arr));  // [11, 54, 55, 152, 520]
    }
}
