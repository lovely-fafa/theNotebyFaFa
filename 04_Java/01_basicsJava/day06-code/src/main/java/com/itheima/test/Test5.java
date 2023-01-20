package com.itheima.test;

public class Test5 {

    public static void main(String[] args) {
        reverseArray2();
    }

    private static void reverseArray1() {
     /*
        数组元素逆序

            第一个和倒数第一个  arr[0] arr[arr.length - 1 - 0]
            第二个和倒数第二个  arr[1] arr[arr.length - 1 - 1]
            第三个和倒数第三个  arr[2] arr[arr.length - 1 - 2]
            ...
            arr[i] arr[arr.length - 1 - i]
     */
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length / 2; i++) {
            int tem = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tem;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static void reverseArray2() {
        /*
            准备两个指针 从两边往中间走 每走一步交换一下
            两者相遇 结束
         */
        int[] arr = {1, 2, 3, 4, 5, 6};
        int star = 0;
        int end = arr.length - 1;
        while (true) {
            int tem = arr[star];
            arr[star] = arr[end];
            arr[end] = tem;
            star ++;
            end --;
            if (end - star <= 1) {
                break;
            }
        }
        for (int i :arr) {
            System.out.println(i);
        }
    }
}
