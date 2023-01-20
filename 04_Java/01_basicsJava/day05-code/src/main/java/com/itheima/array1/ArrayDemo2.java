package com.itheima.array1;

public class ArrayDemo2 {
    public static void main(String[] args) {
        arrayTest();
    }
    public static void arrayTest() {
        int[] arr = {11, 22, 33, 55};
        // 取值
        System.out.println(arr[0]);
        // 改值
        arr[2] = 66;
        System.out.println(arr[2]);
    }
}
