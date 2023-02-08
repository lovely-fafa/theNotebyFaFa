package com.itheima.a02mylist;

import java.util.TreeSet;

public class A07_TreeSetDemo4 {
    public static void main(String[] args) {
        /*
            需求:创建5个学生对象
            属性:(姓名,年龄，语文成绩,数学成绩,英语成绩),
            按照总分从高到低输出到控制台
            如果总分一样，按照语文成绩排如果语文一样，
            按照数学成绩排如果数学成绩一样，按照英语成绩排
            如果英文成绩一样，按照年龄排
            如果年龄一样，按照姓名的字母顺序排
            如果都一样，认为是同一个学生，不存。
         */
        Student stu1 = new Student("zhangsan", 23, 90, 99, 50);
        Student stu2 = new Student("lisi", 24, 90, 98, 50);
        Student stu3 = new Student("wangwu", 25, 95, 100, 30);
        Student stu4 = new Student("zhaoliu", 26, 60, 99, 70);
        Student stu5 = new Student("qianqi", 26, 70, 80, 70);

        TreeSet<Student> ts = new TreeSet<>();
        ts.add(stu1);
        ts.add(stu2);
        ts.add(stu3);
        ts.add(stu4);
        ts.add(stu5);

        for (Student stu : ts) {
            System.out.println(stu.getAll());
            System.out.println(stu);
        }
    }
}
