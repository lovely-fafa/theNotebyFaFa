package com.itheima.myStatic;

public class StaticDemo {
    public static void main(String[] args) {
        System.out.println(Student.school);  // 随着类的加载而加载，优先于对象存在

        Student stu1 = new Student();

        stu1.name = "fafa";
        stu1.age = 22;
        stu1.school = "双流一带专";
        System.out.println(stu1.name + "---" + stu1.age + "---" + stu1.school);

        Student stu2 = new Student();
        stu2.name = "fafafa";
        stu2.age = 24;
        // stu2.school = "双流一带专";  // 可以不需要 因为可以共享
        System.out.println(stu2.name + "---" + stu2.age + "---" + stu2.school);
        System.out.println(Student.school);  // 多了一种调用方法 类名.
    }
}
