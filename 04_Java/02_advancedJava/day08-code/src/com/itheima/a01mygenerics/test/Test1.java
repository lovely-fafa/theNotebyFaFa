package com.itheima.a01mygenerics.test;

import java.util.ArrayList;

public class Test1 {
    /*
        需求:
        定义一个继承结构:
                                    动物
                    |                                   |
                   猫                                   狗
               |        |                        |             |
             滨斯猫     狸花猫                    泰迪          哈士奇
        属性:名字，年龄
        行为:吃东西
            波斯猫方法体打印:一只叫做XXX的，x岁的波斯猫，正在吃小饼干
            狸花猫方法体打印:一只叫做XXX的，X岁的狸花猫，正在吃鱼
            泰迪方法体打印:一只叫做XXX的，X岁的泰迪，正在吃骨头，边吃边蹭
            哈士奇方法体打印:一只叫做XXX的，X岁的哈士奇，正在吃骨头，边吃边拆家

        测试类中定义一个方法用于饲养动物
            public static void keepPet(ArrayList<???> list){
                //遍历集合，调用动物的eat方法
            }
        要求1: 该方法能养所有品种的猫，但是不能养狗
        要求2: 该方法能养所有品种的狗，但是不能养猫
        要求3: 该方法能养所有的动物，但是不能传递其他类型
     */

    public static void main(String[] args) {
        ArrayList<Cat> list1 = new ArrayList<>();
        list1.add(new LuhuaCat("猫猫1号", 22));
        list1.add(new LuhuaCat("猫猫2号", 25));
        list1.add(new LuhuaCat("猫猫3号", 222));

        keepPet(list1);

    }

    public static void keepPet(ArrayList<? extends Animal> list){
        //遍历集合，调用动物的 eat 方法
        for (Animal animal : list) {
            animal.eat();
        }
    }
}
