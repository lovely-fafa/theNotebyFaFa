package com.itheima.design.adapter;

public class AdapterTest2 {
    public static void main(String[] args) {

    }
}

interface 和尚 {
    void 打坐();
    void 念经();
    void 撞钟();
    void 习武();
}

// 这是一个适配器
// 为什么要抽象类 是为了不能被实例化 也就不能被调用内部没有逻辑的方法
abstract class 和尚Adapter implements 和尚 {

    @Override
    public void 打坐() {

    }

    @Override
    public void 念经() {

    }

    @Override
    public void 撞钟() {

    }

    @Override
    public void 习武() {

    }
}

class 鲁智深 extends 和尚Adapter {
    @Override
    public void 习武() {
        System.out.println("大闹野猪林");
        System.out.println("倒拔垂杨柳");
    }
}

class 唐僧 extends 和尚Adapter {
    @Override
    public void 打坐() {
        System.out.println("唐僧打坐...");
    }

    @Override
    public void 念经() {
        System.out.println("唐僧念经...");
    }

    @Override
    public void 撞钟() {
        System.out.println("唐僧撞钟...");
    }
}
