package com.itheima.myExtend;

public class ExtendsDemos {
    public static void main(String[] args) {
        AA a1 = new AA(1, 2, 3);
        AA a2 = new AA(1, 2, 3);
        // 新需求
        AA a3 = new AA(1, 2, 6, 7);
    }
}

class AA {
    int a;
    int b;
    int c;
    // 需求多了一个 d
    int d;

    public AA(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        // 如果在这个地方给 d 赋值 会改其他使用这个构造方法的代码
        // this.d = d
    }

    // 解决办法 方法重载
    public AA(int a, int b, int c, int d) {
        // this.a = a;
        // this.b = b;
        // this.c = c;

        // 简写了...
        this(a, b, c);
        this.d = d;
    }
}
