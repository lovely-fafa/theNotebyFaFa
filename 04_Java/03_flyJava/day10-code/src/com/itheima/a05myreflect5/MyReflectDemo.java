package com.itheima.a05myreflect5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class MyReflectDemo {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        // 对于任意一个对象，都可以把对象所有的字段名和值，保存到文件中去

        Student s = new Student("小A", 23, "女", 167.5, "睡觉");
        Teacher t = new Teacher("播妞", 1000);
        
        saveObject(s);
    }

    private static void saveObject(Object obj) throws IllegalAccessException, IOException {
        // 1. 获取字节码文件对象
        Class clazz = obj.getClass();

        BufferedWriter bw = new BufferedWriter(new FileWriter("day10-code\\src\\com\\itheima\\a05myreflect5\\objInfo.txt"));

        // 2. 获取所有成员变量
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // 名字
            String name = field.getName();
            // 值
            Object value = field.get(obj);

            bw.write(name + "=" + value);
            bw.newLine();
        }
        bw.close();
    }
}
