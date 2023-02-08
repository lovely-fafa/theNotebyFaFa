package com.itheima.b;

/*
    Fu 和 Test 类是不同包下的无关类
 */
public class Test {
    public static void main(String[] args) {
        Zi z = new Zi();
        // z.show();  // 因为是 protected 所以这样会报错
        // 解决办法 先右边 再下面
        z.method();
    }
}
