package com.itheima.doudizhu1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {

    static ArrayList<String> list = new ArrayList<>();

    // 准备牌
    static {
        String[] color = {"♠", "♣", "♥", "♦"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for (String c : color) {
            for (String n : number) {
                list.add(c + n);
            }
        }
        list.add("大王");
        list.add("小王");
    }

    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);

        // 发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);
            // 底牌
            if (i <= 2) {
                lord.add(poker);
                continue;
            }

            // 给玩家
            if (i % 3 == 0) {
                player1.add(poker);
            } else if (i % 3 == 1) {
                player2.add(poker);
            } else {
                player3.add(poker);
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
     * @param list 每位玩家的牌
     */
    public void lookPoker(String name, ArrayList<String> list){
        System.out.print(name + ":");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();

    }

}
