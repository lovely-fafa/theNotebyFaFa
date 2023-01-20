package com.itheima.test;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        /*
            在编程竞赛中，有6个评委为参赛的选手打分，分数为 0-100 的整数分
            选手的最后得分为:去掉一个最高分和一个最低分后 的4个评委平均值
         */
        int[] arr = initArray();

        double avg = getAvg(arr);
        System.out.println("平均分是" + avg);
    }

    private static double getAvg(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        for (int i: arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
            sum += i;
        }

        return (sum - max - min) / ((arr.length - 2) * 1.0);
    }

    private static int[] initArray() {
        /**
         * 用于初始化数组
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入 6 个评委的分数...");
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            while (true) {
                System.out.println("请输入第" + i + "个评委的打分：");
                int score = sc.nextInt();
                if (score > 0 && score < 100){
                    arr[i] = score;
                    break;
                } else {
                    System.out.println("请输入分数为 0-100 的整数分！");
                }
            }
        }
        return arr;
    }
}
