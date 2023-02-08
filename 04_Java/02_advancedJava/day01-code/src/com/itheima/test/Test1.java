package com.itheima.test;

public class Test1 {
    public static void main(String[] args) {
        Teacher t = new Teacher("张三", 30);
        t.teach();

        Student s = new Student("李四", 30, 100);
        s.study();
    }
}
