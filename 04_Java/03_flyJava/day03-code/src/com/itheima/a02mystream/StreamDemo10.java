package com.itheima.a02mystream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamDemo10 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三丰-男-10", "张无忌-男-15", "周芷若-女-14", "赵敏-女-13", "张强-男-20",
                "张翠山-男-4", "张良-男-35", "王二麻子-男-37", "谢广坤-男-41");

        // 1. 收集男性到 List 集合中
        List<String> newList1 = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toList());
        System.out.println(newList1);

        // 2. 收集男性到 Set 集合中
        Set<String> newList2 = list.stream().filter(s -> "男".equals(s.split("-")[1])).collect(Collectors.toSet());
        System.out.println(newList2);

        // 3. 收集男性到 Map 集合中
        // 3.1 匿名内部类
        // 键：姓名
        // 值：年龄
        /**
         * toMap：参数一：键的生成规则
         *        参数二：值的生成规则
         * <p>
         * 参数一：
         *      Function：泛型一：流中每一个数据的类型
         *                泛型二：Map 集合的键的数据类型
         *      apply 形参：流里面的每一个数据
         *          方法体：生成键的代码
         *          返回值：已经生成的键
         * <p>
         * 参数二：
         *      Function：泛型一：流中每一个数据的类型
         *                泛型二：Map 集合的值的数据类型
         *      apply 形参：流里面的每一个数据
         *          方法体：生成值的代码
         *          返回值：已经生成的值
         */
        Map<String, Integer> newList3 = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split("-")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[2]);
                    }
                }));
        System.out.println(newList3);

        // 3.2 Lambda 表达式
        Map<String, Integer> newList4 = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(k -> k.split("-")[0],
                        v -> Integer.parseInt(v.split("-")[2])));
        System.out.println(newList4);
    }
}
