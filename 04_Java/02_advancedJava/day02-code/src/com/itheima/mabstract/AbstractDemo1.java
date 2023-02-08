package com.itheima.mabstract;

public class AbstractDemo1 {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.eat();

        Dog d = new Dog();
        d.eat();
    }
}

abstract class Animal {
    public abstract void eat();  // 每个动物吃什么 都不一样 干脆就抽象类吧
}

class Cat extends Animal{
    // 重写
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("狗吃屎");
    }
}
