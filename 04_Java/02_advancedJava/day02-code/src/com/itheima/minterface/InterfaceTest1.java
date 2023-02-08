package com.itheima.minterface;

public class InterfaceTest1 {
    /*
        接口成员的特点
            1. 成员变量：只能定义常量
                系统会默认加上 public static final 所以要大写
            2. 成员方法：只能是抽象方法
                系统会默认加上 public abstract
            4. 构造方法：没有
                接口没有构造方法 接口的实现类（可以理解为接口的干爹）有 super
                这个 super 是 object
     */
    public static void main(String[] args) {
        System.out.println(MyInter.num);  // 说明带了 static
        // MyInter.num = 20; // 报错 说明有 final
    }
}

interface MyInter {
    // 接口没有构造方法 接口的实现类（可以理解为接口的干爹）有 super
    // 这个 super 是 object
    int num = 10;  // num 所以要大写
}
