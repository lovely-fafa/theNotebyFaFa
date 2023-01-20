package com.itheima.test;

public class Test2 {
    public static void main(String[] args) {
        getEventNumberSum();

    }
    public static void getEventNumberSum () {
        int[] arr = {68, 27, 95, 88, 171, 996, 51, 210};
        int sum = 0;
        for (int i : arr) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            if (ge != 7 && shi != 7 && i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
