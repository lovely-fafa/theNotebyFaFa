package com.itheima.inner;

public class LocalClassTest {
    public static void main(String[] args) {
        A a = new A();
        a.show();
    }
}

class A {
    public void show() {
        class B {
            public void method() {
                System.out.println("method...");
            }
        }
        // method() 只有 B 被实例化了才能用 而实例化 B 必须要 调用了 show()
        B b = new B();
        b.method();
    }
}
