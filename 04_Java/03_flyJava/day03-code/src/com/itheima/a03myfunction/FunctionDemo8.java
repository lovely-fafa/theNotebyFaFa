package com.itheima.a03myfunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDemo8 {
    public static void main(String[] args) {
        /**
         * 需求:
         *      创建集合添加学生对象学牛对象属性
         *      name, age
         * 要求:
         *      获取姓名并放到数组当中
         *      使用方法引用完成
         */
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("张三", 123));
        list.add(new Student("张三1", 1234));
        list.add(new Student("张三2", 12134));

        String[] nameList = list.stream().map(Student::getName).toArray(String[]::new);
        Integer[] ageList = list.stream().map(Student::getAge).toArray(Integer[]::new);

        System.out.println(Arrays.toString(nameList));
        System.out.println(Arrays.toString(ageList));
    }
}
