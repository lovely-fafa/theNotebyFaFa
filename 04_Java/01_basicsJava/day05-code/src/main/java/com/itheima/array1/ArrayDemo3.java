package com.itheima.array1;

public class ArrayDemo3 {
    public static void main(String[] args) {
        arrayTest();
    }
    public static void arrayTest() {
        int[] arr = new int[3];  // 动态初始化
        for (int i: arr) {
            System.out.println(i);  // 默认值 0
        }
    }
}
