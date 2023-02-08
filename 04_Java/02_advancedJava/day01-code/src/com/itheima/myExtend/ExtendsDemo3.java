package com.itheima.myExtend;

public class ExtendsDemo3 {
    public static void main(String[] args) {
        Son s = new Son();
        s.method();
    }
}

class Father {
    public void method() {
        System.out.println("father...method...");
    }
}

class Son extends Father {
    @Override
    public void method() {
        System.out.println("son...method...");
    }
}
