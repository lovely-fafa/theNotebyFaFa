package com.itheima.a01mymap;

public class Student1 implements Comparable<Student1>{
    private String name;
    private int age;

    public Student1() {
    }

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student1{name = " + name + ", age = " + age + "}";
    }

    @Override
    public int compareTo(Student1 o) {
        // this: 要添加
        // o: 红黑树的元素

        //返回值:
        //负数: 表示当前要添加的元是小的，存左边
        // 正数:表示当前要添加的元素是人的，存右边
        // 0: 表示当前要添加的元素已经存在，舍弃
        int i = this.getAge() - o.getAge();
        i = i == 0 ? this.getName().compareTo(o.getName()) : i;

        return i;
    }
}
