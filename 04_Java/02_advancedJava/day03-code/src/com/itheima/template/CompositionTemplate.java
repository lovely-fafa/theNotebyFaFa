package com.itheima.template;

public abstract class CompositionTemplate {
    // 加 final 是为了防止重写 write()
    public final void write() {
        System.out.println("开头");

        body();

        System.out.println("结尾");
    }

    public abstract void body();
}
