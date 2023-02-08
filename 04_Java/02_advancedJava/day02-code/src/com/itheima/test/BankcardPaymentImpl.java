package com.itheima.test;

public class BankcardPaymentImpl implements Payment {
    @Override
    public void pay(double money) {
        System.out.println("通过银行卡支付了：" + money + "元！");
    }
}
