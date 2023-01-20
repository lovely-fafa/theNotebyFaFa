package com.itheima.test;

public class Test4 {
    public static void main(String[] args) {
        int num = 109;
        int[] arr = {19, 520, 520, 526};
        System.out.println(getIndex(num, arr));
    }
    // 查找元素在数组中的索引
    public static int getIndex(int num, int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                index = i;
                break;
            }
        }
        return index;
    }
}
