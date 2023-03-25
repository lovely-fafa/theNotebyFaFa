package com.itheima.a03myreflect3;

import java.lang.reflect.Field;

public class MyReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class clazz = Class.forName("com.itheima.a03myreflect3.Student");

        // 获取成员变量
        // 公共的成员变量
        Field[] fields1 = clazz.getFields();  // 公共的成员变量
        for (Field field : fields1) {
            System.out.println(field);
        }

        System.out.println("----------------------------");

        // 所有的成员变量
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field);
        }

        System.out.println("----------------------------");

        // 单个
        Field gender = clazz.getField("gender");
        System.out.println(gender);

        Field age = clazz.getDeclaredField("age");
        System.out.println(age);

        // 获取权限修饰符
        int modifiers = age.getModifiers();
        System.out.println(modifiers);
        // 获取成员变量的名字
        System.out.println(age.getName());
        // 获取成员变量的数据类型
        System.out.println(age.getType());

        // 获取成员变量的值
        Student stu = new Student("fafa", 22, "女");
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);  // 权限校验
        String value = (String) name.get(stu);  // 拿到值
        System.out.println(value);

        // 修改
        name.set(stu, "fafafa");
        System.out.println(stu);
    }
}
