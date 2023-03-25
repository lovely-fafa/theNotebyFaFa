package com.itheima.a01immutable;

import java.util.Map;
import java.util.Set;

public class ImmutableDemo3 {
    public static void main(String[] args) {
        /*
            细节1：键不能重复
            细节2：最多传 20 个参数 也就是说只能有 10 对键值对
            细节3：如果非要大于 20 个 可以把键值对看成一个整体
         */

        Map<String, String> map = Map.of("张三", "南京", "李四", "北京", "王五", "天津");

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + "=" + map.get(key));
        }

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }

    // 为什么要有最大的个数限制
//    public static<K, V> void of(K...keys, V...values) {
//        // 可以看到这个地方报错了 因为可变参数只能有一个且在最后
//    }
}
