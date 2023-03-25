package com.itheima.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        /*
            班级里有5个学生
            要求:
            被点到的学生，不会再被点到。
            但是如果班级中所有的学生都点完了，需要重新开启第二轮点名。
        */

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list1, "范闲", "范建", "范统", "杜子腾", "杜琦燕", "宋合泛", "侯笼藤", "朱益群", "朱穆朗玛峰", "袁明媛");
        int count = list1.size();
        Random r = new Random();

        for (int j = 0; j < 10; j++) {

            System.out.println("----------第" + j + "轮点名----------");

            for (int i = 0; i < count; i++) {
                int index = r.nextInt(list1.size());
                String name = list1.remove(index);
                list2.add(name);
                System.out.println(name);
            }

            list1.addAll(list2);
            list2.clear();
        }
    }
}
