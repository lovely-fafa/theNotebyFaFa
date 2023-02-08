package com.itheima.system;

public class SystemDemo {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55};
        int [] destArr = new int[3];
        System.arraycopy(arr, 2, destArr, 0, 3);

        for (int i : destArr) {
            System.out.println(i);
        }
    }
}
