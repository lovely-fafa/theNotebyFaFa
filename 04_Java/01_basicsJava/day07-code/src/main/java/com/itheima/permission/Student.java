package com.itheima.permission;

public class Student {
    /*
        1.私有成员变量的目的 保证安全性

        2.针对私有的成员变量，提供对应的 setXxx 和 getXxx 方法

            set：设置
            get：获取
     */
    private int age;
    public void setAge(int age) {
        if (age > 1 && age <= 120){
            this.age = age;
        } else {
            System.out.println("年龄有误...");
        }
    }
    public int getAge() {
        return age;
    }
}
