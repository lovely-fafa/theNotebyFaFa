package com.itheima.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    public static void main(String[] args) {

        // 方法一：不推荐
        BigDecimal bd11 = new BigDecimal(0.1);
        BigDecimal bd12 = new BigDecimal(0.2);

        System.out.println(bd11.add(bd12));  // 0.3000000000000000166533453693773481063544750213623046875

        // 方法二
        BigDecimal bd21 = new BigDecimal("0.1");
        BigDecimal bd22 = new BigDecimal("0.2");

        System.out.println(bd21.add(bd22));  // 0.3

        // 方法三
        BigDecimal bd31 = BigDecimal.valueOf(0.1);
        BigDecimal bd32 = BigDecimal.valueOf(0.2);

        System.out.println(bd31.add(bd32));  // 0.3

        System.out.println("--------------------------------");

        // 成员方法
        System.out.println(bd31.add(bd32));  // 加
        System.out.println(bd31.subtract(bd32));  // 减
        System.out.println(bd31.multiply(bd32));  // 乘
        System.out.println(bd31.divide(bd32));  // 除

        BigDecimal bd41 = BigDecimal.valueOf(10.0);
        BigDecimal bd42 = BigDecimal.valueOf(3.0);
        // 下面这个是除不尽 要报错
        // System.out.println(bd41.divide(bd42));
        // 如果除不尽 提供了 方法重载的
        System.out.println(bd41.divide(bd42, 2, RoundingMode.HALF_UP));  // 3.33
        System.out.println(bd41.divide(bd42, 2, RoundingMode.UP));  // 3.34
        System.out.println(bd41.divide(bd42, 2, RoundingMode.DOWN));  // 3.33
        
        // 接收
        // 默认是 BigDecimal 类型
        BigDecimal res = bd41.divide(bd42, 2, RoundingMode.UP);
        // 转换
        double res_double = res.doubleValue();
        System.out.println(Math.abs(res_double));  // 这样就不会报错了
    }
}
