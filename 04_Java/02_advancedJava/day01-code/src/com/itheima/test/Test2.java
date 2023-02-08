package com.itheima.test;

public class Test2 {
    public static void main(String[] args) {
        Coder c = new Coder("张三", 23, 15000);
        c.work();

        Manager m = new Manager("李四", 25, 15000, 300);
        m.work();
    }
}
