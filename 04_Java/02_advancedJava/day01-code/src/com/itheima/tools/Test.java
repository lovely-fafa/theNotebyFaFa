package com.itheima.tools;

public class Test {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 58};

        // ArrayTools tools = new ArrayTools();  // 私有了构造方法

        // 直接 对象名. 调用
        System.out.println(ArrayTools.getMax(arr));
        System.out.println(ArrayTools.getMin(arr));
        ArrayTools.printArray(arr);

        // 比如说这个就是
        System.exit(0);
    }
}
