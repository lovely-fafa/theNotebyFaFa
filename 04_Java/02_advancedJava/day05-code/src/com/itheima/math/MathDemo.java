package com.itheima.math;

public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.abs(-123.452));
        System.out.println("-----------------------");
        // 向上取整
        System.out.println(Math.ceil(12.0));  // 12.0
        System.out.println(Math.ceil(12.2));  // 13.0
        System.out.println(Math.ceil(12.5));  // 13.0
        System.out.println(Math.ceil(12.9));  // 13.0
        System.out.println("-----------------------");
        // 向下取整
        System.out.println(Math.floor(12.0));  // 12.0
        System.out.println(Math.floor(12.2));  // 12.0
        System.out.println(Math.floor(12.5));  // 12.0
        System.out.println(Math.floor(12.9));  // 12.0
        System.out.println("-----------------------");
        // 四舍五入
        System.out.println(Math.round(12.3));

        System.out.println(Math.max(12, 0.85));
        System.out.println(Math.min(12, 0.85));

        System.out.println(Math.pow(2, 3));  // 2 的 3 次幂

        System.out.println(Math.random());  // [0.0, 1.0) 随机数
    }
}
