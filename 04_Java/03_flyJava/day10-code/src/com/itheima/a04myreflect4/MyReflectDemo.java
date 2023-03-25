package com.itheima.a04myreflect4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MyReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName("com.itheima.a04myreflect4.Student");

        // 获取所有公共方法 包含父类的
        Method[] methods1 = clazz.getMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }

        System.out.println("-----------------------------");

        // 获取所有的方法 不能获取父类的 但是可以获取私有的
        Method[] methods2 = clazz.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }

        System.out.println("-----------------------------");

        // 指定的单一方法
        Method m = clazz.getDeclaredMethod("eat", String.class);  // 这里指定类型 是因为有方法重载
        System.out.println(m);

        // 修饰符
        int modifiers = m.getModifiers();
        System.out.println(modifiers);
        // 名字
        System.out.println(m.getName());
        // 参数
        Parameter[] parameters = m.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        // 异常
        Class[] exceptionTypes = m.getExceptionTypes();
        for (Class exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }

        // 方法运行
        Student stu = new Student("fafa", 22);
        m.setAccessible(true);
        String result = (String) m.invoke(stu, "巧克力");
        System.out.println(result);
    }
}
