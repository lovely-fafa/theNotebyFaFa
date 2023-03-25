package com.itheima.a03myfunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FunctionDemo7 {
    public static void main(String[] args) {
        /*
            需求:
                集合中存储一些字符中的散据，比如: 张三,23
                收集到student美型的数组当中
         */
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌,15", "阳在术,14", "赵做,13", "张,20", "张三1,188", "紫举山,40");

        Student[] arr = list.stream().map(Student::new).toArray(Student[]::new);
        System.out.println(Arrays.toString(arr));
    }
}
