package com.itheima.a02mylist;

import java.util.TreeSet;

public class A07_TreeSetDemo3 {
    public static void main(String[] args) {
        /*
            需求:请自行选择比较器排序和自然排序两种方式;
            要求:存入四个字符串，“c”，“ab”，“df”，“qwer”
            按照长度排序，如果一样长则按照首宁字母排序
         */
        TreeSet<String> ts = new TreeSet<>((o1, o2) -> {
                // o1：当前要添加的元素
                // o2：已经在红黑树的元素
                // 返回值：和之前一样
                int i = o1.length() - o2.length();
                // 如果长度一样 就按照首字母（调用 String 已经写好的）
                i = i == 0 ? o1.compareTo(o2) : i;
                return i;
        });

        ts.add("c");
        ts.add("ab");
        ts.add("df");
        ts.add("qwer");

        System.out.println(ts);  // [c, ab, df, qwer]
    }
}
