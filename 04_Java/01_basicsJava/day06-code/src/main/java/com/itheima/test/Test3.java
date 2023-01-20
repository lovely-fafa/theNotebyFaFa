package com.itheima.test;

public class Test3 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 3, 4};
        int[] arr3 = {1, 2, 3};

        System.out.println(checkArrayContent(arr1, arr2));
        System.out.println(checkArrayContent(arr1, arr3));
    }
    public static boolean checkArrayContent(int[] arr1, int[] arr2) {
        /*
            比较两个数组内容是否相同
            长度，内容，顺序完全相同
         */
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
