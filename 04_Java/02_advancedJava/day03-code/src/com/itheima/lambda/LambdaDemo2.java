package com.itheima.lambda;

public class LambdaDemo2 {
    public static void main(String[] args) {
        userInterB(new InterB() {
            @Override
            public void show1() {
                System.out.println("匿名内部类...show1...");
            }

            @Override
            public void show2() {
                System.out.println("匿名内部类...show2...");
            }
        });

        System.out.println("--------------------");

        // userInterB( () -> {});
        // Lambda 表达式只允许操作函数式接口
    }

    public static void userInterB(InterB b) {
        b.show1();
        b.show2();
    }

}

// @FunctionalInterface  // 校验是否是函数式接口
interface InterB {
    void show1();
    void show2();
}
