package com.itheima.myExtend;

public class ExtendsDemo2 {
    public static void main(String[] args) {
        Zi z = new Zi();
        z.method();
        z.show();
    }
}

class Fu {
    int num = 10;
    public void show() {
        System.out.println("Fu...show");
    }
}

class Zi extends Fu {
    int num = 20;
    public void method() {
        System.out.println(num);  // 20
        System.out.println(super.num);  // 10
    }
    public void show() {
        System.out.println("Zi...show");
    }
}
