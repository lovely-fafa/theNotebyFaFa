package com.itheima.array1;

public class ArrayTest1 {
    public static void main(String[] args) {
        getSum();
    }
    public static void printArray() {
        int[] arr = {11, 22, 3, 44, 55, 66};
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // 快捷操作 数组名.fori
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
        // idea 提示可以
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /*
        列表的偶数求和
     */
    public static void getSum() {
        int[] arr = {11, 22, 33, 44, 55};
        int sum = 0;
        for (int i: arr) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
