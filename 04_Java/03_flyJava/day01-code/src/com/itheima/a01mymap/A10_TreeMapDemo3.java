package com.itheima.a01mymap;

import java.util.TreeMap;
import java.util.function.BiConsumer;

public class A10_TreeMapDemo3 {
    public static void main(String[] args) {
        /*
            需求:
                学符串“aababcabcdabcde”
                请统计字符串中每一个字符出现的次数，并按照以下格式输出
            输出结果:
                a(5) b(4) c(3) d(2) e(1)
         */
        String s = "aababcabcdabcde";
        TreeMap<Character, Integer> tm = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (tm.containsKey(c)) {
                tm.put(c, tm.get(c) + 1);
            } else {
                tm.put(c, 1);
            }
        }

        StringBuilder sb = new StringBuilder();

        tm.forEach(new BiConsumer<Character, Integer>() {
            @Override
            public void accept(Character key, Integer value) {
                sb.append(key).append("(").append(value).append(") ");
            }
        });

        System.out.println(sb);  // a(5) b(4) c(3) d(2) e(1)
    }
}
