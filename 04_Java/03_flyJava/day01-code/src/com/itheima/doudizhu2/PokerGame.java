package com.itheima.doudizhu2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {

    // {1=♠3, 2=♣3, 3=♥3, 4=♦3, 5=♠4, 6=♣4, 7=♥4, 8=♦4, 9=♠5, 10=♣5, 11=♥5, 12=♦5,
    // 13=♠6, 14=♣6, 15=♥6, 16=♦6, 17=♠7, 18=♣7, 19=♥7, 20=♦7, 21=♠8, 22=♣8, 23=♥8,
    // 24=♦8, 25=♠9, 26=♣9, 27=♥9, 28=♦9, 29=♠10, 30=♣10, 31=♥10, 32=♦10, 33=♠J,
    // 34=♣J, 35=♥J, 36=♦J, 37=♠Q, 38=♣Q, 39=♥Q, 40=♦Q, 41=♠K, 42=♣K, 43=♥K, 44=♦K,
    // 45=♠A, 46=♣A, 47=♥A, 48=♦A, 49=♠2, 50=♣2, 51=♥2, 52=♦2, 53=小王, 54=大王}
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        String[] color = {"♠", "♣", "♥", "♦"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        // 序号
        int serialNumber = 1;

        for (String n : number) {
            for (String c : color) {
                list.add(serialNumber);
                hm.put(serialNumber, c + n);
                serialNumber ++;
            }
        }

        hm.put(serialNumber, "小王");
        list.add(serialNumber);
        serialNumber ++;
        hm.put(serialNumber, "大王");
        list.add(serialNumber);

        System.out.println(hm);
    }

    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);
        // 发牌
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            int serialNumber = list.get(i);
            // 底牌
            if (i <= 2) {
                lord.add(serialNumber);
                continue;
            }

            // 给玩家
            if (i % 3 == 0) {
                player1.add(serialNumber);
            } else if (i % 3 == 1) {
                player2.add(serialNumber);
            } else {
                player3.add(serialNumber);
            }
        }

        // 看牌
        lookPoker("底牌", lord);
        lookPoker("杠脑壳", player1);
        lookPoker("大帅比", player2);
        lookPoker("蛋筒", player3);
    }

    /**
     *
     * @param name 玩家名字
     * @param ts 每位玩家的牌
     */
    public void lookPoker(String name, TreeSet<Integer> ts){
        System.out.print(name + ":");
        for (Integer serialNumber : ts) {
            System.out.print(hm.get(serialNumber) + " ");
        }
        System.out.println();

    }

}
