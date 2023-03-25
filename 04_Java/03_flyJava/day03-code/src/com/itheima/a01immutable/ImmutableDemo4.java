package com.itheima.a01immutable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ImmutableDemo4 {
    public static void main(String[] args) {
        // 细节3：如果非要大于 20 个 可以把键值对看成一个整体

        // 1. 创建普通的 map 集合
        HashMap<String, String> hm = new HashMap<>();
        hm.put("张三", "南京");
        hm.put("李四", "北京");
        hm.put("王五", "上海");
        hm.put("赵六", "北京");
        hm.put("孙七", "深圳");
        hm.put("周八", "杭州");
        hm.put("吴九", "宁波");
        hm.put("郑十", "无锡");
        hm.put("刘一", "苏州");
        hm.put("陈二", "嘉兴");
        hm.put("aaa", "111");

        // 2. 利用上面的数据获取一个不可变集合的方法一
        // 获取键值对（entry对象）
        Set<Map.Entry<String, String>> entries = hm.entrySet();

        // 把 entry 变成数组
        // 这个地方的 0 是数组的长度
        Map.Entry[] arr1 = new Map.Entry[0];

        // toArray 方法在底层会比较集合的长度跟数组的长度两者的大小
        // 如果集合的长度 > 数组的长度 : 数据在数组中放不下，此时会根据实际数据的个数，重新创建数组
        // 如果集合的长度 <= 数组的长度: 数据在数组中放的下，此时不会创建新的数组，而是直接用
        // 所以上面那个 0 可以随便写
        Map.Entry[] arr2 = entries.toArray(arr1);  // 这里使用的带参构造 是为了告诉他 数组里面的类型是 Entry 对象

        // 得到不可变的 map 集合
        Map map1 = Map.ofEntries(arr2);

        // 3. 利用上面的数据获取一个不可变集合的方法二（方法一精简版）
        Map map2 = Map.ofEntries(hm.entrySet().toArray(new Map.Entry[0]));

        // 4. 利用上面的数据获取一个不可变集合的方法三（方法二的接口）
        // JDK 10 才有的 底层就是方法二
        Map<String, String> map3 = Map.copyOf(hm);
    }
}
