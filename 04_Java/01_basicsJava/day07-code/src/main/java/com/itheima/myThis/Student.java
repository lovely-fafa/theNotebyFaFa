package com.itheima.myThis;

public class Student {
    String name;

    public void sayHello(String name) {
        System.out.println(name);  // 西域狂鸭
        System.out.println(this.name);  // 肛门吹雪
        this.method();  // this 可以调本类的方法
    }
    public void method() {
        System.out.println("method...");
    }
}
