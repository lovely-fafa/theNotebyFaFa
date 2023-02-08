package com.itheima.test;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {11, 520, 55, 152, 54};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
