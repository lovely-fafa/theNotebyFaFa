package com.itheima.array1;

import java.util.Scanner;

public class ArrayTest3 {
    public static void main(String[] args) {
        arrayTest();
    }

    public static void arrayTest() {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i=0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个数：");
            arr[i] = sc.nextInt();
        }
    }
}
