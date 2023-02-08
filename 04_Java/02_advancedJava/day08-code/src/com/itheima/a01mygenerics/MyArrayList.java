package com.itheima.a01mygenerics;

import java.util.Arrays;

/*
*  当我在编写个类的叫候，如果不确定类型，耶么这个类就可以定义为泛型类
 */
public class MyArrayList<E> {

    Object[] obj = new Object[10];
    int size;
    /*
    E：不确定的类型 在类名后面已经定义了
    e：形参名，变量名
     */
    public boolean add(E e){
        obj[size] = e;
        size ++;
        return true;
    }

    public E get(int index) {
        return (E) obj[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(obj);
    }
}
