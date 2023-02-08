package com.itheima.polymorphism;

public class PolymorphismTest2 {
    public static void main(String[] args) {
        // 继承的例子
        Fu f = new Zi();
        System.out.println(f.num);  // 编译看左边（父类），运行看左边（父类）
        f.show();  // 编译看左边（父类），运行看右边（子类）
        f.print();  // 调用静态成员 是父类的 因为编译是时会变成 Fu.print()

        System.out.println("----------------");

        // 实现的例子
        Inter i = new InterImpl();
        i.method();  // 编译看左边（父类），运行看右边（子类）
    }
}

interface Inter {
    void method();
}

class InterImpl implements Inter {

    @Override
    public void method() {
        System.out.println("show...");
    }
}

class Fu {
    int num = 10;
    public void show() {
        System.out.println("Fu...show");
    }
    // 这是一个静态的成员
    public static void print() {
        System.out.println("Fu...print");
    }
}

class Zi extends Fu {
    int num = 20;
    public void show() {
        System.out.println("Zi...show");
    }
    // 这是一个静态的成员
    public static void print() {
        System.out.println("Zi...print");
    }
}
