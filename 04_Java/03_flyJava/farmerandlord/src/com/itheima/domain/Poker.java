package com.itheima.domain;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Poker extends JLabel implements MouseListener {
    //自己练习
    static ArrayList<String> list = new ArrayList<>();
    static HashMap<String, Integer> hm = new HashMap<>();

    static {
        String[] color = {"♠", "♣", "♥", "♦"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for (String c : color) {
            for (String n : number) {
                list.add(c + n);
            }
        }
        list.add(" 大王");
        list.add(" 小王");

        // 指定价值
        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("大王", 16);
        hm.put("小王", 17);
    }
    public void PokerGame() {
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

        // 排序
        order(lord);
        order(player1);
        order(player2);
        order(player3);

        // 看牌
        lookPoker("底牌", lord);
        lookPoker("杠脑壳", player1);
        lookPoker("大帅比", player2);
        lookPoker("蛋筒", player3);
    }

    private void order(ArrayList<String> list) {
    Collections.sort(list, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            String color1 = o1.substring(0, 1);
            String color2 = o2.substring(0, 1);
            int value1 = getValue(o1);
            int value2 = getValue(o2);

            int i = value1 - value2;
            return i == 0 ? color1.compareTo(color2) : i;
        }
    });
    }

    private int getValue(String poker) {
        String number = poker.substring(1);
        if (hm.containsKey(number)) {
            return hm.get(number);
        } else {
            return Integer.parseInt(number);
        }
    }

    /**
     *
     * @param name 玩家名字
     * @param list 每位玩家的牌
     */
    public void lookPoker(String name, ArrayList<String> list){
        System.out.print(name + ": ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
