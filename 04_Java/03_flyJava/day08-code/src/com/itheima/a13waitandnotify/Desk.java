package com.itheima.a13waitandnotify;

public class Desk {
    // 表示座子上是否有面条
    public static int foodFlag = 0;

    // 总个数
    public static int count = 10;

    // 锁对象
    public static Object lock = new Object();
}
