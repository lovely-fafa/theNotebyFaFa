package com.itheima.a06myreflect6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class MyReflectDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("day10-code\\src\\prop.properties");
        prop.load(fis);
        fis.close();

        // 获取全类名
        String className = (String) prop.get("classname");
        String methodName = (String) prop.get("method");
        
        // 利用反射创建对象并运行方法
        Class clazz = Class.forName(className);
        // 获取构造方法
        Constructor con = clazz.getDeclaredConstructor();
        Student stu = (Student) con.newInstance();
        System.out.println(stu);
        // clazz.newInstance();  // 过时

        // 获取成员方法
        Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);
        // 运行
        method.invoke(stu);
    }
}
