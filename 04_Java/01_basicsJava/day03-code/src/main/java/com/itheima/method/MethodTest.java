package com.itheima.method;

public class MethodTest {
    public static void main(String[] args) {
        int result = getMax(10, 20);
        System.out.println(result);
    }
    // void 当前方法 没有返回值
    public static int getMax(int num1, int num2) {
        int max = num1 > num2 ? num1 : num2;
        System.out.println(max);
        return max;
    }
}
