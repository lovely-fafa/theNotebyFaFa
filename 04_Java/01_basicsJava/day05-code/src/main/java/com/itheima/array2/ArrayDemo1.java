package com.itheima.array2;

public class ArrayDemo1 {
    public static void main(String[] args) {
        int [][] arr = {
                {11, 22, 33},
                {44, 55, 66}
        };
        System.out.println(arr);  // [[I@254989ff

        //  二维数组存储一维数组时，是一维数组的地址值
        System.out.println(arr[0]);  // [I@5d099f62
        System.out.println(arr[1]);  // [I@37f8bb67

        System.out.println(arr[0][0]);  // 11
    }
}
