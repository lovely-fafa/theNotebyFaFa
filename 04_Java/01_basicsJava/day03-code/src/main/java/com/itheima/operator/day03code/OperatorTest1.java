package com.itheima.operator.day03code;
import java.util.Scanner;
public class OperatorTest1 {
    /*
    三个数找最大值
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个整数");

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int temMax = num1 > num2 ? num1 : num2;
        int max = temMax > num3 ? temMax : num3;

        System.out.println("最大值为" + max);
    }
}
