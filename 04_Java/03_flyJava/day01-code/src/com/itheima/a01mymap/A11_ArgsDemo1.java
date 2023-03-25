package com.itheima.a01mymap;

public class A11_ArgsDemo1 {
    public static void main(String[] args) {
        // JDK 5
        // 可变参数
        // 方法的形参个数可以是变化的
        // 底层:
        // 可变参数底层就是一个数组
        // 只不过不需要我们自己创建了，Java会帮我们创建好

        getSum(1, 2, 3, 4, 5);

    }

    public static void getSum(int ... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        System.out.println(sum);
    }
}
