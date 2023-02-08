package com.itheima.myExtend.constructor;

public class Test {
    public static void main(String[] args) {
        Zi z1 = new Zi();
        Zi z2 = new Zi(3);
    }
}

class Fu {
    public Fu() {
        System.out.println("Fu类的空参构造");
    }
    public Fu(int num) {
        System.out.println("Fu类的带参构造");
    }
}

class Zi extends Fu {
    public Zi () {
        // super();  // 默认隐藏的
        System.out.println("Zi类的空参构造");
    }
    public Zi (int num) {
        // super();  // 默认隐藏的
        System.out.println("Zi类的带参构造");
    }
}
