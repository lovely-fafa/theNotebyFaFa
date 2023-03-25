package com.itheima.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        /*
            定义一个集合，并添加一些整数 1,2,3,4,5,6,7,8,9,18
            过滤奇数，只留下偶数。
            并将结果保存起来
         */
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 18);

        List<Integer> newList = list.stream()
                .filter(s -> s % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(newList);
    }
}
