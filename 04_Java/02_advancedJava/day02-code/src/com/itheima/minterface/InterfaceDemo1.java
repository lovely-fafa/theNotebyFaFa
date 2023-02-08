package com.itheima.minterface;

public class InterfaceDemo1 {
    public static void main(String[] args) {
        // 创建实现类对象
        InterImp1 ii = new InterImp1();
        ii.method();
        ii.show();
    }
}

// 定义接口
interface Inter {
    public abstract void show();  // 因为是定义接口 所以这个地方只能是 abstract
    public abstract void method();
}

// 实现类
// 方法一：重写所有抽象对象
class InterImp1 implements Inter {

    @Override
    public void show() {

    }

    @Override
    public void method() {

    }
}

// 实现类
// 方法二：将实现类变为抽象类（很少使用）
abstract class InterImp2 implements Inter {
}
