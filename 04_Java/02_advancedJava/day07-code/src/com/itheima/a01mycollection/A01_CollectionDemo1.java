package com.itheima.a01mycollection;

import java.util.ArrayList;
import java.util.Collection;

public class A01_CollectionDemo1 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        // 1. 添加元素
        // 细节1：如果我们要往 List 系列集合中添加数据，那么方法永远返回 true，因为 List 系列的是允许元素重复的。
        // 细节2：如果我们要往 Set 系列集合中添加数帮，如果当前要添加元素不存在，方法返回 true，表示添加成功。
        //       如果当前要添加的元素已经存在，方法返回 false，表示添加失败 因为 Set 系列的集合不允许重复。
        coll.add("aa0");
        coll.add("aa1");
        coll.add("aa2");
        coll.add("aa3");
        System.out.println(coll);

        // 2. 清空
        coll.clear();
        System.out.println();

        // 3. 删除
        // 细节1: 因为 Collection 里面定义的是共性的方法 set 没有索引 所以这个地方不能通过索引进行删除 只能通过元素的对象进行删除
        // 细节2: 方法会有一个布尔类型的返回值，删除成功返回 true，刚除失败返回 false
        //       如果要删除的元素不存在，就会删除失败。
        coll.add("aa0");
        coll.add("aa1");
        coll.add("aa2");
        coll.add("aa3");
        coll.remove("aa3");
        System.out.println(coll);

        // 4. 判断元素是否存在
        // 底层依赖 equals 方法进行判断是否存在的
        // 所以自定义对象 默认继承 object 的 equals 的方法 比较地址值 所以就会错 所以自定义对象需要重写 equals 方法
        boolean result = coll.contains("aa3");
        System.out.println(result);

        // 5. 判断集合是否为空
        /*
            public boolean isEmpty() {
                return size == 0;
            }
         */
        boolean result2 = coll.isEmpty();
        System.out.println(result2);

        // 6. 获取集合的长度
        System.out.println(coll.size());
    }
}
