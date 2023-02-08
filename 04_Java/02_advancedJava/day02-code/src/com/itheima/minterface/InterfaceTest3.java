package com.itheima.minterface;

/*
    接口和类之间的各种关系：
        1.类和类之间：继承关系，只支持单承，不支持多继承，但是可以多层继承
        2.类和接口之间：实观关系，可以单实现，也可以多实现，甚至可以在继承一个类的同时，实现多个接口
        3.接口和接口之问：维承关系，可以单继承，也可以多继承
 */
public class InterfaceTest3 {
    public static void main(String[] args) {

    }
}

interface A {
    void showA();
    void showAll();
}

interface B {
    void showB();
    void showAll();
}

// 可以单实现，也可以多实现
class ABIml implements A, B {

    @Override
    public void showA() {

    }

    @Override
    public void showAll() {

    }

    @Override
    public void showB() {

    }
}

class Fu {
    public void showAll() {
        System.out.println("showAll...");
    }
}

//甚至可以在继承一个类的同时，实现多个接口
class Zi extends Fu implements A, B {
    // 这个时候 showAll() 已经被继承的父类重写了
    @Override
    public void showA() {

    }

    @Override
    public void showB() {

    }
}

// 3.接口和接口之问：维承关系，可以单继承，也可以多继承
interface InterC extends A, B {
    // 比如说还有一个 抽象方法
    void showC();
}
// 实现时
class InterCImpl implements InterC {

    @Override
    public void showA() {

    }

    @Override
    public void showB() {

    }

    // 这个地方就没有逻辑冲突
    @Override
    public void showAll() {

    }

    @Override
    public void showC() {

    }
}
