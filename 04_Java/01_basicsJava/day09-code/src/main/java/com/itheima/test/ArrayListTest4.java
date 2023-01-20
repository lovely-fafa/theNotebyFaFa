package com.itheima.test;

import java.util.ArrayList;

public class ArrayListTest4 {
    public static void main(String[] args) {
        methodTwo();
    }

    private static void methodTwo() {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("test");
        list.add("张三");
        list.add("test");
        list.add("test");

        // 倒着遍历 就可以不用 i--
        for (int i = list.size() - 1; i >=0; i--) {
            if ("test".equals(list.get(i))) {
                list.remove(i);
            }
        }
    }

    private static void methodOne() {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("test");
        list.add("张三");
        list.add("test");
        list.add("test");

        for (int i = 0; i < list.size(); i++) {
            // 这个地方 变量和常量 之间比较 如果是
            // list.get(i).equals("test")
            // 有可能取出来的东西 不是字符串 就会报错 比如说 null 报空指针异常
            if ("test".equals(list.get(i))) {
                list.remove(i);
                i--;  // 我觉得你应该知道为什么这个地方要 i-- 我就不写注释了
            }
        }
    }
}
