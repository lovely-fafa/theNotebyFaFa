package com.itheima.myExtend;

public class ExtendsDemo1 {
    public static void main(String[] args) {
        Coder c = new Coder();
        c.setAge(2);
        c.setName("fafa");

        System.out.println(c.getName() + "---" + c.getAge());
    }
}

class Employee {
    private String name;
    private int age;

    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

// 继承
class Coder extends Employee {

}
class Manager extends Employee {

}
