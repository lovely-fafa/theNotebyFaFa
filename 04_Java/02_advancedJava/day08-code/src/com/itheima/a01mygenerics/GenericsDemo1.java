package com.itheima.a01mygenerics;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericsDemo1 {
    public static void main(String[] args) {
        // 没有泛型时 怎么存储数据
        ArrayList list = new ArrayList<>();
        // 如果我们没有给集合指定类型，默认认为所有的数据类型都是 object 类型
        // 此时可以往集合添加任意的数据类型。
        // 带来一个坏处：我们在获取数据的时候，无法使用他的特有行为。
        list.add(123);
        list.add("aaa");
        list.add(new Student("张三", 123));
        // 遍历集合
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            // 多态的弊端是不能范围子类特有功能 这个地方如果要强转 但是不知道强转成什么类型
            System.out.println(obj);
        }
        // 为了解决上面这个问题 便引入了泛型这个概念
    }
}
