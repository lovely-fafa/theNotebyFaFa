package com.itheima.test;

public class Manager extends Employee{
    private double bonus;
    public Manager() {
    }

    public Manager(String name, int age, int salary, double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("姓名为：" + super.getName() + "年龄为" + super.getAge() + "工资为" + super.getSalary() + "奖金为" + bonus);
    }
}
