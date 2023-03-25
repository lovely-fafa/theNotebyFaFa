package com.itheima.a02mystream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class StreamDemo7 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张无忌", "张无忌", "周芷若", "赵镇", "张", "张三丰", "张攀山", "张良", "王二麻子", "谢广坤");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "fafa");

        // 去重
        list1.stream().distinct().forEach(s -> System.out.println(s));

        // 合并 a 和 b 两个流
        Stream.concat(list1.stream(), list2.stream()).forEach(s -> System.out.println(s));
    }
}
