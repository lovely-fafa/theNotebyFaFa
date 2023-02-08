package com.itheima.myExtend;

public class ExtendsDemo4 {
    public static void main(String[] args) {
        C c = new C();
        c.methodA();
        c.methodB();
        c.methodC();
    }
}

class A {
    public void methodA() {
        System.out.println("AA...");
    }
}

class B extends A {
    public void methodB() {
        System.out.println("B...");
    }
}

class C extends B{
    public void methodC() {
        System.out.println("C...");
    }
}