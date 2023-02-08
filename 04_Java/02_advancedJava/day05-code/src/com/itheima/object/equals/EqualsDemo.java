package com.itheima.object.equals;

import com.itheima.object.tostring.Student;

import java.util.Objects;

public class EqualsDemo {
    /*
        Object 的 equals 方法
            public boolean equals(Object obj) {
                // this: stu1
                // obj: stu2
                return (this == obj);
            }

        结论：默认比较的是内存地址，通常会重写这个方法
     */
    public static void main(String[] args) {
        Student stu1 = new Student("张三", 23);
        Student stu2 = new Student("张三", 23);

        System.out.println(stu1 == stu2); // false
        System.out.println(stu1.equals(stu2));  // false / true

        // equals 还是依赖我们自己编写的 equals方法 但是好处是内部会判断是否为 null
        /*
                public static boolean equals(Object a, Object b) {
                    // a == b : 地址相同 返回 true 这里是 短路的 或 左边为 true 右边不执行
                                地址不相同 为 false 短路或还要执行右边
                -------------------------------------------------------
                    // a != null : 我们假设 a 为 null 那么 null != null 为 false
                    // 这个地方是双与 就不执行右边了 所以这个地方 null 是调用不了 equals 就不会空指针异常了
                -------------------------------------------------------
                    // a != null : 我们假设 a 不为 null 那么 不是null != null 为 true
                    // 这个地方是双与 执行右边了 但是现在不是 null 的调用了 equals 就不会空指针异常了

                    return (a == b) || (a != null && a.equals(b));
                }
         */
        System.out.println(Objects.equals(stu1, stu2));
    }
}
