package com.itheima.a01mycollection;

import java.util.ArrayList;
import java.util.Collection;

public class A02_CollectionDemo2 {
    public static void main(String[] args) {
        Collection<Student> coll = new ArrayList<>();

        Student s1 = new Student("张三", 23);
        Student s2 = new Student("张三1", 123);
        Student s3 = new Student("张三11", 231);

        coll.add(s1);
        coll.add(s2);
        coll.add(s3);

        Student s4 = new Student("张三", 23);
        // 因为contains方法在底层依赖equals方法判断对象是否一致的。
        // 如果在的是自定义对象，没有重写equals方法，那么默认他用object类中的equals方法进行判断，而object类中equals方法，依赖地址值进行判断
        // 所以需要重写 equals 方法
        System.out.println(coll.contains(s4));
    }
}
