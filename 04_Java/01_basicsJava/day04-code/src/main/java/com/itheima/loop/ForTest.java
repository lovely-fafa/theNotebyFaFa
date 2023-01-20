package com.itheima.loop;

public class ForTest {
    public static void main(String[] args) {
        print99();
    }

    public static void daffodilNumber() {
        // 准备计数
        int count = 0;
        for (int i = 100; i <= 999; i++) {
            // 提取位
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100;

            // 判断
            if (ge * ge * ge + shi * shi * shi + bai *bai * bai == i) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("水仙花数的个数是：" + count);
    }

    public static void printRectangle() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <=5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void printRectangle2() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void print99() {
        for (int i = 1; i<=9; i++) {
            for (int j = 1; j<=i; j++) {
                System.out.print(j + "*" + i + "=" + i*j + "\t");
            }
            System.out.println();
        }
    }
}
