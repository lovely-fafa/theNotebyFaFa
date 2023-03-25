package com.itheima.myiotest4;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Properties prop = new Properties();

        // 细节虽然我们可以往Properties当中添加任意的数据类型，但是一般只会往里面添加字符申类型的数据
        prop.put("aaa", "111");
        prop.put("a0aa", "111");
        prop.put("aa0a", "111");
        prop.put("0aaa", "111");

        // 1. 遍历
        Set<Object> keySet = prop.keySet();
        for (Object k : keySet) {
            System.out.println(k + " = " + prop.get(k));
        }

        // 2. 遍历
        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
