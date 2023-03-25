package com.itheima.test;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        ArrayList<String> city1 = new ArrayList<>();
        city1.add("南京市");
        city1.add("扬州市");

        ArrayList<String> city2 = new ArrayList<>();
        city2.add("石家庄市");
        city2.add("唐山市");

        ArrayList<String> city3 = new ArrayList<>();
        city3.add("遂宁市");
        city3.add("成都市");

        hm.put("江苏省", city1);
        hm.put("河北省", city2);
        hm.put("四川省", city3);

        Set<Map.Entry<String, ArrayList<String>>> entries = hm.entrySet();
        for (Map.Entry<String, ArrayList<String>> entry : entries) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            
            StringJoiner sj = new StringJoiner("", "", "");
            for (String s : value) {
                sj.add(s);
            }

            System.out.println(key + " = " + sj);
            
        }
    }
}
