package com.itheima.test;

public class Teacher extends Person{
    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }
    public void teach () {
        System.out.println("姓名" + super.getName() + "，年龄为" + super.getAge());
    }
}
