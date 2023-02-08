package com.itheima.object.tostring;

import java.util.ArrayList;

public class ToStringDemo {
    /*
        Object.toString()

            public String toString() {
                return getClass().getName() + "@" + Integer.toHexString(hashCode());
            }

        getCLass().getName(): 类名称，全类名(包名 + 类名)
        Integer.toHexString(hashCode()): 转十六进制
        hashCode(): 返回对象的内存地址 + 哈希算法，算出来的整数（哈希值）

        ------------------------------------------

        细节：使用打印语句，打印对象名的时候，println 方法，源码层面，会自动调用该对象的 toString 方祛
            public static string valueDf(Object obj) {
                return (obj == null] ? "nul" : obj.toString();
            }

     */
    public static void main(String[] args) {
        A a = new A();

        System.out.println(a);  // com.itheima.object.tostring.A@3b07d329
        System.out.println(a.toString());  // com.itheima.object.tostring.A@3b07d329

        Student stu = new Student("张三", 23);
        System.out.println(stu);

        // 所以 arrayList 重写了 toString
        ArrayList<String> arr = new ArrayList<>();
        arr.add("123");
        arr.add("123");
        arr.add("123");
        System.out.println(arr);
    }
}

class A {
    @Override
    public String toString() {
        return "大哥重写了 toString 方法";
    }
}
