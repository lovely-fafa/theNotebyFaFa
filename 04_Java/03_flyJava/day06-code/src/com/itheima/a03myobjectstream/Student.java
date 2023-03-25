package com.itheima.a03myobjectstream;

import java.io.Serial;
import java.io.Serializable;

/**
 * Serializable 即可没有抽象方法 这种接口叫做 标记型接口
 * 一但实现了这个接口 那么就表示当前的 Student 类可以被反序列化
 * 可以理解为：合格证
 */

public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = -3544011625688167053L;
    private String name;
    private int age;
    private String address;
    // transient: 瞬态关键字
    // 作用:不会把当前属性序列化到本地文件当中
    private transient int id;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(long serialVersionUID, String name, int age, String address, int id) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.id = id;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

    /**
     * 获取
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}
