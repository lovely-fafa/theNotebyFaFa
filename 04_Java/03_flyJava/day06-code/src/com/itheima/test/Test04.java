package com.itheima.test;

import java.io.*;
import java.util.ArrayList;

public class Test04 {
    // 将多个自定义对象序列化到文件中，但是由于对象的个数不确定，反序列化流该如何读取呢?
    public static void main(String[] args) throws IOException {
        Student stu1 = new Student("zhangsan", 23, "南京");
        Student stu2 = new Student("zlisi", 230, "北京");
        Student stu3 = new Student("zhangsi", 253, "天津");

        ArrayList<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day06-code\\e.txt"));
        oos.writeObject(list);
        oos.close();
    }
}
