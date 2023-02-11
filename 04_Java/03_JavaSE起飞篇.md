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

```java
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
```

### 4.5 源码分析

- ```TreeMap```添加元素的时候，键是否需要重写```hashCode```和```equals```方法?

  此时是不需要重写的。

  ```HashMap```是哈希表结构的，```JDK8```开始由数组，链表，红黑树组成的。

- 既然有红黑树，```HashMap```的键是否需要实现```Compareable```接口或者传递比较器对象呢?

  不需要的。

  因为在```Hashmap```的底层，默认是利用哈希值的大小关系来创建红黑树的

- ```TreeMap```和```HashMap```谁的效率更高？

  如果是最坏情况，添加了8个元素，这8个元素形成了链表，此时```TreeMap```的效率要更高但是这种情况出现的几率非常的少。一般而言，还是```HashMap```的效率要更高。

- 你觉得在```Map```集合中，Java会提供一个如果键重复了，不会覆盖的```put```方法呢？

  此时```putIfAbsent```本身不重要。

  传递一个思想:代码中的逻辑都有两面性，如果我们只知道了其中的A面，而且代码中还发现了有变量可以控制两面性的发生。

  那么该逻辑一定会有B面。

  习惯：

  - ```boolean```类型的变量控制

    一般只有AB两面，因为```boolean```只有两个值

  - ```int```类型的变量控制

    一般至少有三面，因为```int```可以取多个值。

- 三种双列集合，以后如何选择?
  ```HashMap``` ```LinkedHashMap``` ```TreeMap```

  - 默认：```HashMap```（效率最高）
  - 如果要保证存取有序：```LinkedHashMap```
  - 如果要进行排序：```TreeMap```

# day 02综合项目

## 1 可变参数

### 1.1 使用方法

```java
public class A11_ArgsDemo1 {
    public static void main(String[] args) {
        // JDK 5
        // 可变参数
        // 方法的形参个数可以是变化的
        // 底层:
        // 可变参数底层就是一个数组
        // 只不过不需要我们自己创建了，Java会帮我们创建好

        getSum(1, 2, 3, 4, 5);

    }

    public static void getSum(int ... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        System.out.println(sum);
    }
}
```

### 1.2 总结

- 可变参数本质上就是一个数组

- 作用：在形参中接收多个数据

- 格式：```数据类型...参数名称```

  举例：```int...a```

- 注意事项：

  形参列表中可变参数只能有一个

  可变参数必须放在形参列表的最后面

## 2 Collections

> - java.util.Collections：是集合工具类
> - 作用```Collections```不是集合，而是集合的工具类

### 2.1 Collections 常用 API

|                           方法名称                           |              说明               |
| :----------------------------------------------------------: | :-----------------------------: |
| ```public static <T> boolean addAll(Collection<T> c, T ... elements)``` |          批量添加元素           |
|        ```public static void shuffle(List<?> list)```        |     打乱List集合元素的顺序      |
|       ```public static <T> void sort(List<T> list)```        |              排序               |
| ```public static <T> void sort(List<T> list，Comparator<T> c)``` |     根据指定的规则进行排序      |
| ```public static <T> int binarySearch (List<T> list, T key)``` |      以二分查找法查找元素       |
| ```public static <T> void copy(List<T> dest, List<T> src)``` |        拷贝集合中的元素         |
|    ```public static <T> int fill (List<T> list, T obj)```    |     使用指定的元素填充集合      |
|   ```public static <T> void max/min(Collection<T> coll)```   | 根据默认的自然排序获取最大/小值 |
| ```public static <T> void swap(List<?> list,int i,int j)```  |    交换集合中指定位置的元素     |

```java
import java.util.ArrayList;
import java.util.Collections;

public class A13_CollectionsDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, "abxc", "ac", "abc", "123");
        System.out.println(list);  // [abxc, ac, abc, 123]

        Collections.shuffle(list);
        System.out.println(list);  // [ac, abxc, abc, 123]
    }
}
```

### 2.2 综合小练习

#### 2.2.1 随机点名

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        /*
            随机点名
         */
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "范闲","范建","范统","杜子腾","杜琦燕","宋合泛","侯笼藤","朱益群","朱穆朗玛峰","袁明媛");
        Random r = new Random();
        int index = r.nextInt(list.size());
        System.out.println(list.get(index));

        Collections.shuffle(list);
        System.out.println(list.get(0));
    }
}
```

#### 2.2.2 带概率的随机点名

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        /*
            班级里有N个学生
            要求:
                70%的概率随机到男生
                30%的概率随机到女生
         */
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 1, 1, 1, 1, 1, 1);
        Collections.addAll(list, 0, 0, 0);
        Collections.shuffle(list);

        Random r = new Random();
        Integer number = list.get(r.nextInt(list.size()));

        ArrayList<String> boyList = new ArrayList<>();
        ArrayList<String> girlList = new ArrayList<>();

        Collections.addAll(boyList, "范闲", "范建", "范统", "杜子腾", "杜琦燕", "宋合泛", "侯笼藤", "朱益群", "朱穆朗玛峰", "袁明媛");
        Collections.addAll(girlList, "杜琦燕", "袁明媛", "李猜", "田蜜蜜");

        if (number == 1) {
            System.out.println(boyList.get(r.nextInt(boyList.size())));
        } else {
            System.out.println(girlList.get(r.nextInt(girlList.size())));
        }
    }
}
```

#### 2.2.3 不重复的随机点名

```java
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
```

## 3 集合嵌套

```java
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
```

















