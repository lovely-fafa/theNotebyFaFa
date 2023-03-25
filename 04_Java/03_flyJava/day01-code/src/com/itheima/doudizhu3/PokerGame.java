package com.itheima.doudizhu3;

import java.util.*;

public class PokerGame {
    static HashMap<String, Integer> hm = new HashMap<>();
    static ArrayList<String> list = new ArrayList<>();

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

    /**
     * 根据牌的价值排序
     * @param
     */
    public void order(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            // Array.sort
            @Override
            public int compare(String o1, String o2) {
                // o1: 当前要插入到有序序列的牌
                // o2: 有序序列有的牌

                // 返回负数：o1 是小的 插到前面
                // 返回负数：o1 是大的 插到后面
                // 返回 0：继续按花色排

                // 计算 o1 o2
                String color1 = o1.substring(0, 1);
                String color2 = o2.substring(0, 1);
                int value1 = getValue(o1);
                int value2 = getValue(o2);

                // 比较
                int i = value1 - value2;
                return i == 0 ? color1.compareTo(color2) : i;
            }
        });
    }

    /**
     * 计算牌的价值
     * @return
     */
    public int getValue(String poker) {
        String number = poker.substring(1);
        if (hm.containsKey(number)) {
            return hm.get(number);
        } else {
            return Integer.parseInt(number);
        }
    }
}
