package com.itheima.list;

import java.util.ArrayList;

public class ArrayListDemo2 {
    public static void main(String[] args) {
        readMethod();
    }

    private static void readMethod() {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张三1");
        list.add("张三2");

        String res = list.get(1);
        System.out.println(res);

        System.out.println(list.size());
    }

    private static void updateMethod() {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张三1");
        list.add("张三2");

        String res = list.set(0, "李四");  // 返回被覆盖的
        System.out.println(res);
        System.out.println(list);
    }

    private static void removeMethod() {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张三1");
        list.add("张三2");

        System.out.println(list);
        String res = list.remove(1);
        System.out.println(res);  // 返回删除的
        System.out.println(list);

        boolean flag = list.remove("张三");  // 返回删除是否成功
        boolean flag2 = list.remove("张三5");  // 返回删除是否成功
        System.out.println(flag);
        System.out.println(flag2);
    }

    private static void addMethod() {
        ArrayList<String> list = new ArrayList<>();
        // 居然还有返回值
        // 返回值都是 true 所以没有必要接
        // 但是 所以就不能 链式编程
        boolean b1 = list.add("张三");
        System.out.println(b1);

        list.add(0, "张三4");
    }
}
