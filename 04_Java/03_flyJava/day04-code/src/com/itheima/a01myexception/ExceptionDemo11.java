package com.itheima.a01myexception;

public class ExceptionDemo11 {
    public static void main(String[] args) {
        int[] arr = {11, 12, 0};
        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            String message = e.getMessage();
            System.out.println(message);  // Index 10 out of bounds for length 3

            String string = e.toString();
            System.out.println(string);  // java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 3

            e.printStackTrace();  // java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 3 at com.itheima.a01myexception.ExceptionDemo11.main(ExceptionDemo11.java:7)
        }
        System.out.println("看看我执行了吗");

        // 正常的输出语句
        System.out.println(123);
        // 错误的输出顺序
        System.err.println(123);
    }
}
