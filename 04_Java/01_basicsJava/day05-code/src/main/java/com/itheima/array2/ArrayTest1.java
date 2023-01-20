package com.itheima.array2;

public class ArrayTest1 {
    public static void main(String[] args) {
        int [][] arr = {
                {11, 22, 33},
                {44, 55, 66}
        };
        printArray(arr);
    }
    public static void printArray(int [][] arr) {
        for (int[] i: arr) {
            for (int j: i) {
                System.out.println(j);
            }
        }
    }
}
