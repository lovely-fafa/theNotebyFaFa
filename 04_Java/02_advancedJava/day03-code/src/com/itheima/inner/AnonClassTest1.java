package com.itheima.inner;

public class AnonClassTest1 {
    public static void main(String[] args) {
        // 方法的形参是接口类型 我们应该传入接口的实现类对象 可以看到 这很麻烦
        userInter(new InterImpl());

        // 使用匿名内部类 在定义这个类的同时就进行了实例化
        userInter(new Inter() {
            @Override
            public void show() {
                System.out.println("匿名内部类...show...");
            }
        });
    }

    public static void userInter(Inter i) {
        i.show();
    }
}

// 这是一个接口
interface Inter {
    void show();
}

// 实现这个接口
class InterImpl implements Inter {
    // 重写方法
    @Override
    public void show() {
        System.out.println("Inter..show...");
    }
}
