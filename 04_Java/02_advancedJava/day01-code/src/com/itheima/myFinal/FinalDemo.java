package com.itheima.myFinal;

public class FinalDemo {
    public static void main(String[] args) {
        final int num = 10;
        // num = 20;  // 不能修改
        System.out.println(num);

        final int[] arr = {1, 2, 3};
        // arr = new int[3];  // 不能改地址值
        arr[0] = 0;  // 可以改内容
        System.out.println(arr[0]);  // 0
    }
}

final class Fu extends Object {
    public final void method() {
        System.out.println("父类中的重要方法，不希望子类进行修改...");
    }
}

class Student {
    //final int num;  // final 修饰成员变量 不能修饰默认值 但是 可以在构造方法中赋值 则该句不报错
    final int num = 0;
}
