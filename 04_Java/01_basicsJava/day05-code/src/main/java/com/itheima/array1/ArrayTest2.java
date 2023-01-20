package com.itheima.array1;

import java.util.Random;

public class ArrayTest2 {
    public static void main(String[] args) {
        int[] arr1 = {2, 588, 888, 1000, 1000};
        getLottery(arr1);
    }
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
    public static void getLottery(int[] arr) {
        Random r = new Random();

    }
}
