package com.itheima.a01myexception;

public class ExceptionDemo6 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 5};
        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // 出现了 ArrayIndexOutOfBoundsException 异常 我该如何处理
            System.out.println(e.toString());
        }
        System.out.println("看看我执行了吗？");
    }
}
