package com.itheima.inner;

public class InnerTest {
    public static void main(String[] args) {
        Outer.Inner oi = new Outer().new Inner();
        System.out.println(oi.num);
        oi.show();

        System.out.println("----------------");

        MyOut.MyInner mm = new MyOut().new MyInner();
        mm.show();
    }
}

class Outer {
    private void method() {
        System.out.println("method");
        Inner i = new Inner();  // 外部类中，访问内部类成员：需要创建对象访问
        System.out.println(i.num);
    }

    class Inner {
        int num = 10;
        public void show() {
            System.out.println("show");
            method();  // 内部内访问外部类的方法
        }
    }
}

// 面试题
class MyOut {
    int num = 10;

    class MyInner {
        int num = 20;

        public void show() {
            int num = 30;
            System.out.println(num);  // 30
            System.out.println(this.num);  // 20
            System.out.println(MyOut.this.num);  // 10
        }
    }
}

