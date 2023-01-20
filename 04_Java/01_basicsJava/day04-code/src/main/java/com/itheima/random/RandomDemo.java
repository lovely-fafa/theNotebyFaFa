package com.itheima.random;

import java.util.Random;
import java.util.Scanner;

public class RandomDemo {
    public static void main(String[] args) {
        guessNumber();
    }

    public static void randomTest() {
        Random r = new Random();
        int num = r.nextInt(1, 101);
        System.out.println(num);
    }

    public static void guessNumber() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        int num = r.nextInt(1, 101);

        while (true) {
            System.out.println("\n请输入：");
            int guess = sc.nextInt();

            if (guess < num) {
                System.out.println("猜小了...");
            } else if (guess > num) {
                System.out.println("猜大了...");
            } else {
                System.out.println("猜对了...");
                System.out.println("恭喜！");
                break;
            }
        }
    }
}
