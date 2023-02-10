# day 01 集合进阶

## 1 双列集合

### 1.1 特点

- 双列集合一次需要存一对数据，分别为键和值
- 键不能重复，值可以重复
- 键和值是一一对应的，每一个键只能找到自己对应的值
- 键+值这个整体 我们称之为“键值对”或者“键值对对象”，在Java中叫做```Entry```对象

### 1.2 Map 的常见 API

> Map是双列集合的顶层接口，它的功能是全部双列集合都可以继承使用的

|                 方法名称                  |                 说明                 |
| :---------------------------------------: | :----------------------------------: |
|        ```V put(K key,V value)```         |               添加元素               |
|        ```V remove(object key)```         |         根据键删除键值对元素         |
|            ```void clear()```             |         移除所有的键值对元素         |
|   ```boolean containsKey(object key)```   |       判断集合是否包含指定的键       |
| ```boolean containsValue(object value)``` |       判断集合是否包含指定的值       |
|          ```boolean isEmpty()```          |           判断集合是否为空           |
|             ```int size()```              | 集合的长度，也就是集合中键值对的个数 |

```java
import java.util.HashMap;
import java.util.Map;

public class A01_MapDemo1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        // 1. 添加
        map.put("郭靖", "黄蓉");
        map.put("韦小宝", "沐剑屏");
        String value1 = map.put("尹志平", "小龙女");
        System.out.println(value1);  // null

        // 在添加数据的时候，如果键不存在，那么直接把键值对对象添加到 map 集合当中
        // 在添加数据的时候，如果键是存在的，那么会把原有的键值对对象覆盖，会把被覆盖的值进行返回.
        String value = map.put("韦小宝", "双儿");
        System.out.println(value);  // 沐剑屏
        System.out.println(map);

        // 2. 删除
        String res = map.remove("韦小宝");
        System.out.println(res);
        System.out.println(map);

        // 3. 清空
        // map.clear();

        // 4. 判断是否存在
        System.out.println(map.containsKey("郭靖"));  // true
        System.out.println(map.containsKey("郭靖1"));  // false
        System.out.println(map.containsValue("郭靖1"));  // false

        // 5 是否空
        boolean res1 = map.isEmpty();
        System.out.println(res1);  // false

        // 6 长度
        int size = map.size();  // false
        System.out.println(size);  // 2
    }
}
```

### 1.3 Map 集合遍历——键找值

```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class A02_MapDemo2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("郭靖", "黄蓉");
        map.put("韦小宝", "沐剑屏");
        map.put("尹志平", "小龙女");

        // 1. 键找值...
        Set<String> keys = map.keySet();
        // 1.1 增强 for
        for (String key : keys) {
            System.out.println(key + " = " + map.get(key));
        }
        
        // 1.2 迭代器
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + " = " + map.get(key));
        }
        
        // 1.3 Lambda
        keys.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + " = " + map.get(s));
            }
        });
        keys.forEach(s -> System.out.println(s + " = " + map.get(s)));
    }
}
```

### 1.3 Map 集合遍历——键值对

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class A03_MapDemo3 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("郭靖", "黄蓉");
        map.put("韦小宝", "沐剑屏");
        map.put("尹志平", "小龙女");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

### 1.3 Map 集合遍历——Lambda 表达式

|                           方法名称                           |         说明          |
| :----------------------------------------------------------: | :-------------------: |
| ```default void forEach(BiConsumer<? super K ? super V> action)``` | 结合lambda遍历Map集合 |

```java
public class A04_MapDemo4 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("郭靖", "黄蓉");
        map.put("韦小宝", "沐剑屏");
        map.put("尹志平", "小龙女");

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + " = " + value);
            }
        });

        map.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
```

## 2 HashMap

### 2.1 HashMap 特点

- ```HashMap```是```Map```里面的一个实现类
- 没有额外需要学习的特有方法，直接使用Map里面的方法就可以了
- 特点都是由键决定的：无序、不重复、无索引
- ```HashMap```跟```HashSet```底层原理是一模一样的，都是哈希表结构

### 2.2 底层原理

- ```HashMap```底层是哈希表结构的
- 依赖```hashCode```方法和```equals```法保证键的唯一
- 如果键存储的是自定义对象，需要重写```hashCode```和```equals```方法。如果值存储自定义对象，不需要重写```hashCode```和```equals```方法

### 2.3 经典 python 统计词频 java 实现

```java
import java.util.*;

public class A05_HashDemo2 {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C", "D"};

        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            list.add(arr[r.nextInt(arr.length)]);
        }

        HashMap<String, Integer> hm = new HashMap<>();

        for (String name : list) {
            if (hm.containsKey(name)) {
                hm.put(name, hm.get(name) + 1);
            } else {
                hm.put(name, 1);
            }
        }

        System.out.println(hm);

        int max = 0;
        String result = null;
        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        System.out.println(result);
    }
}
```

## 3 LinkedHashMap

- 由键决定：**有序**、不重复、无索引。
- 这里的有序指的是保证存储和取出的元素顺序一致
- **原理**：底层数据结构是依然哈希表，只是每个键值对元素又额外的多了一个双链表的机制记录存储的顺序。

```java
import java.util.LinkedHashMap;

public class A07_LinkedHashMapDemo1 {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("a", 789);
        lhm.put("b", 585);
        lhm.put("c", 455);

        System.out.println(lhm);
    }
}
```

## 4 TreeMap

### 4.1 介绍

- ```TreeMap```跟```TreeSet```底层原理一样，都是红黑树结构的
- 由键决定特性：不重复、无索引、可排序
- 可排序：**对键进行排序**
- 注意：默认按照键的从小到大进行排序，也可以自己规定键的排序规则
  - 实现```Comparable```接口，指定比较规则。
  - 创建集合时传递```Comparator```比较器对象，指定比较规则

### 4.2 简单的

```java
import java.util.Comparator;
import java.util.TreeMap;

public class A08_TreeMapDemo1 {
    /*
        降序排列
     */
    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        tm.put(1, "奥利奥");
        tm.put(2, "康师傅");
        tm.put(4, "六个核桃");
        tm.put(5, "可口可乐");
        tm.put(3, "雪碧");

        System.out.println(tm);  // {5=可口可乐, 4=六个核桃, 3=雪碧, 2=康师傅, 1=奥利奥}
    }
}
```

### 4.3 自定义对象

```java
import java.util.TreeMap;

public class A09_TreeMapDemo2 {
    public static void main(String[] args) {
        TreeMap<Student1, String> tm = new TreeMap<>();

        Student1 s1 = new Student1("张三", 23);
        Student1 s2 = new Student1("李四", 24);
        Student1 s3 = new Student1("王五", 25);

        tm.put(s1, "北京");
        tm.put(s2, "天津");
        tm.put(s3, "上海");

        System.out.println(tm);
    }
}
```

```java
package com.itheima.a01mymap;

public class Student1 implements Comparable<Student1>{
    private String name;
    private int age;

    ...

    @Override
    public int compareTo(Student1 o) {
        // this: 要添加
        // o: 红黑树的元素

        //返回值:
        //负数: 表示当前要添加的元是小的，存左边
        // 正数:表示当前要添加的元素是人的，存右边
        // 0: 表示当前要添加的元素已经存在，舍弃
        int i = this.getAge() - o.getAge();
        i = i == 0 ? this.getName().compareTo(o.getName()) : i;

        return i;
    }
}
```

### 4.4 小案例：统计个数

需求:学符串“aababcabcdabcde'
请统计字符串中每一个字符出现的次数，并按照以下格式输出
输出结果:
a(5)b(4)c(3) d(2) e(1)

















