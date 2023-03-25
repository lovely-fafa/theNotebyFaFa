package com.itheima.a03myfunction;

import java.util.ArrayList;
import java.util.Collections;

public class FunctionDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");

        // 其他类
        list.stream().filter(new StringOperation1()::stringJude).forEach(s -> System.out.println(s));

        // 本类
        // list.stream().filter(this.stringJude()).forEach(s -> System.out.println(s));  // 静态方法是不能 this 的
        list.stream().filter(new FunctionDemo3()::stringJude).forEach(s -> System.out.println(s));  // 静态方法是不能 this 的

    }

    public boolean stringJude(String s) {
        return s.startsWith("张")  && s.length() == 3;
    }
}
