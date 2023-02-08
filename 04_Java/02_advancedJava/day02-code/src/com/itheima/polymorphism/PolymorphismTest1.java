package com.itheima.polymorphism;

public class PolymorphismTest1 {
    public static void main(String[] args) {
        // Dog d = new Dog();
        Animal a1 = new Dog();
        Animal a2 = new Cat();
    }
}

abstract class Animal {
    public abstract void eat();
}

class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("狗吃屎");
    }
}

class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
