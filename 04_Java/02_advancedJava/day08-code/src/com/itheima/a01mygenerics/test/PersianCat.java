package com.itheima.a01mygenerics.test;

public class PersianCat extends Cat {
    PersianCat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做" + getName() + "的，" + getAge() + "岁的波斯猫，正在吃小饼干...");
    }
}
