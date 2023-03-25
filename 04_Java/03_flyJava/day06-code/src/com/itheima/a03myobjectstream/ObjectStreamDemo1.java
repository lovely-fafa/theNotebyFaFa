package com.itheima.a03myobjectstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo1 {
    public static void main(String[] args) throws IOException {
        Student stu = new Student("张三", 23);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day06-code\\d.txt"));
        oos.writeObject(stu);
        oos.close();
    }
}
