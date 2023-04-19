package com.itheima.test;

public class Square {
    private double chang;
    private double kuan;

    public Square(double chang, double kuan) {
        this.chang = chang;
        this.kuan = kuan;
    }
    // 构造方法
    public Square() {

    }

    public double getChang() {
        return this.chang;
    }

    public void setChang(double chang) {
        this.chang = chang;
    }

    public void setKuan(double Kuan) {
        this.chang = Kuan;
    }


    public double getPerimeter() {
        return 2 * (chang + kuan);
    }

    public double getArea() {
        return chang * kuan;
    }
}
