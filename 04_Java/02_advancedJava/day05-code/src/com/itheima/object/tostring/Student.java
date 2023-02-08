package com.itheima.object.tostring;

import java.util.Objects;

public class Student {
    private String name;
    private int age;

    /*@Override
    public boolean equals(Object obj) {
        // this：谁调用 this 谁就是 this
        // obj：stu2

        // 判断类型
        if (obj instanceof Student) {
            // 向下转型
            Student stu = (Student) obj;
            return this.age == stu.age && this.name.equals(stu.name);
        } else {
            return false;
        }
    }
    */

    // 快捷键
    @Override
    public boolean equals(Object o) {
        // 地址值相同就直接 true
        if (this == o) {
            return true;
        }
        // 代码能走到这 调用者不是 null 如果是会空指针异常
        // o 是 null 就可以 false 了
        if (o == null ||
                // getClass() 是 Object 的
                // 这个地方在比较字节码是否相同 字节码不同则 false
                getClass() != o.getClass()) {
            return false;
        }
        // 代码能到这 相当于字节码相同 即类型相同 所以开始向下转型
        Student student = (Student) o;
        // 属性比较
        return age == student.age && name.equals(student.name);
    }

    public Student() {
    }

    public Student(String name, int age) {
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
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
