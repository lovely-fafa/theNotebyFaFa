package com.itheima.inner;

public class StaticInnerTest {
    public static void main(String[] args) {
        // 非静态 要实例化才能调
        OuterClass.InnerClass oi = new OuterClass.InnerClass();
        oi.show();

        OuterClass.InnerClass.showStatic();  // 静态直接调
    }
}

class OuterClass {

    int num1 = 10;
    static int num2 = 10;

    static class InnerClass {
        // 成员内部类
        public void show() {
            System.out.println("show...");
        }

        // 静态内部类
        public static void showStatic() {
            System.out.println("show...");

            // 静态只能调静态
            System.out.println(num2);

            // 非静态 需要 new
            OuterClass o = new OuterClass();
            System.out.println(o.num1);
        }
    }
}