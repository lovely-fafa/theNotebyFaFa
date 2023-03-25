package com.itheima.a02mystream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class StreamDemo9 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌-10", "周芷若-50", "赵镇-30", "张-20");

        // 1. 遍历
        // 1.1 匿名内部类
        list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // 1.2 Lambda 表达式
        list.stream().forEach(s -> System.out.println(s));

        // 2. 统计
        long count = list.stream().count();
        System.out.println(count);

        // 3. 搜集
        // 3.1 空参构造 但是是 object 类型的
        Object[] arr1 = list.stream().toArray();
        System.out.println(arr1);

        // 3.2 带参构造之匿名内部类
        // IntFunction 的泛型：具体类型的数组
        // apply 的形参：流中数据的个数，要跟数组的长度保持一致
        // apply 的返回值：具体类型的数组
        // 方法体：就是创建数组
        String[] arr2 = list.stream().toArray(new IntFunction<String[]>() {
            // toArray 方法的参数的作用: 负责创建一个指定类型的数组
            // toArray 方法的底层，会依次得到流里面的每一个数据，并把数据放到数组当中
            // toArray 方法的返回值: 是一个装着流里面所有数据的数组
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });

        System.out.println(Arrays.toString(arr2));  // [张无忌-10, 周芷若-50, 赵镇-30, 张-20]

        // 3.3 带参构造之 Lambda 表达式
        String[] arr3 = list.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(arr3));
    }
}
