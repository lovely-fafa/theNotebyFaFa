package com.itheima.test;

public class Student extends Person{

    private double score;

    public Student() {
    }

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void study() {
        System.out.println("姓名" + super.getName() + "，年龄为" + super.getAge() + "，成绩为" + score);
    }
}
