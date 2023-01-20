package com.itheima.array1;

public class ArrayDemo1 {
    public static void main(String[] args) {
        arrayTest2();
    }
    public static void arrayTest2() {
        // 完整格式
        int[] arr1 = new int[]{1, 2, 3};
        // 简化格式
        int[] arr2 = {11, 22, 33};
        double[] arr3 = {1.1, 1.2, 1.3};

        System.out.println(arr1);  // [I@254989ff
        System.out.println(arr2);  // [I@5d099f62
        System.out.println(arr3);  // [I@5d099f62

        /*
        [I@5d099f62

        @：分隔符
        [：当前空间是数组类型的
        I：当前数组类型，是 int 类型
        5d099f62：数组的十六进制地址
         */
    }
}
