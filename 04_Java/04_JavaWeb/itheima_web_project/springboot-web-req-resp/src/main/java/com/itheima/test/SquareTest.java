package com.itheima.test;

import java.util.*;

public class SquareTest {
    public static void main(String[] args) {

        Scanner reader=new Scanner(System.in);
        System.out.print("请输入矩形的宽；");
        double chang;
        chang=reader.nextDouble();
        System.out.print("请输入矩形的高：");
        double kuan;
        kuan=reader.nextDouble();

//        Square squ = new Square(chang,kuan);
        Square squ = new Square();  // 合理隐藏 合理暴露
        System.out.println(squ);
        squ.setChang(chang);
        squ.setKuan(kuan);
//        squ.setP(chang, kuan);
        System.out.println("矩形的周长是"+squ.getPerimeter());
        System.out.println("矩形的面积是"+squ.getArea());
    }
}

