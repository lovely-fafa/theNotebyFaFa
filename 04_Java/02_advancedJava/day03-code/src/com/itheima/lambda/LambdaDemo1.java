package com.itheima.lambda;

public class LambdaDemo1 {
    public static void main(String[] args) {
        // 匿名内部类
        userInterA(new InterA() {
            @Override
            public void show() {
                System.out.println("匿名内部类，重写后的 show 方法...");
            }
        });

        // Lambda 表达式
        userInterA( () -> {
            System.out.println("Lambda，重写后的 show 方法...");
        });
    }

    public static void userInterA(InterA a) {
        a.show();
    }
}

interface InterA {
    void show();
}
