package com.itheima.a02myreflect2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class MyReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1. 获取字节码
        Class clazz = Class.forName("com.itheima.a02myreflect2.Student");

        // 2. 获取构造方法
        Constructor[] cons1 = clazz.getConstructors();
        for (Constructor con : cons1) {
            System.out.println(con);
        }

        System.out.println("---------------------------------------");

        Constructor[] cons2 = clazz.getDeclaredConstructors();
        for (Constructor con : cons2) {
            System.out.println(con);
        }

        System.out.println("---------------------------------------");

        Constructor con1 = clazz.getDeclaredConstructor();
        System.out.println(con1);

        System.out.println("---------------------------------------");

        Constructor con2 = clazz.getDeclaredConstructor(String.class);  // 参数和构造方法的参数一样
        System.out.println(con2);

        System.out.println("---------------------------------------");

        Constructor con3 = clazz.getDeclaredConstructor(int.class);  // 参数和构造方法的参数一样
        System.out.println(con3);

        System.out.println("---------------------------------------");

        Constructor con4 = clazz.getDeclaredConstructor(String.class, int.class);  // 参数和构造方法的参数一样
        System.out.println(con4);

        // 获取权限修饰符
        int modifiers = con4.getModifiers();
        System.out.println(modifiers);

        // 获取参数
        Parameter[] parameters = con4.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }

        // 创建对象
        // 临时取消权限校验
        con4.setAccessible(true);  // 暴力反射
        Student stu = (Student) con4.newInstance("张三", 222);
        System.out.println(stu);
    }
}
