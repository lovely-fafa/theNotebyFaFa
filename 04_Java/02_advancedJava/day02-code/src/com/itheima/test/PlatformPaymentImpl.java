package com.itheima.test;

public class PlatformPaymentImpl implements Payment{
    @Override
    public void pay(double money) {
        System.out.println("使用平台支付了：" + money + "元！");
    }
}
