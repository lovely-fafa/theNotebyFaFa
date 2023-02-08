package com.itheima.stonepuzzle;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(514, 595);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("石头迷阵 V1.0");
        frame.setAlwaysOnTop(true);  // 置顶
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        int[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel imageLabel = new JLabel(new ImageIcon("E:\\程序员\\发发的笔记\\advancedJava\\day04-code\\src\\com\\itheima\\stonepuzzle\\image\\" + data[i][j] + ".png"));
                imageLabel.setBounds(50 + 100 * j, 90 + 100 * i, 100, 100);
                frame.getContentPane().add(imageLabel);
            }
        }

        JLabel background = new JLabel(new ImageIcon("E:\\程序员\\发发的笔记\\advancedJava\\day04-code\\src\\com\\itheima\\stonepuzzle\\image\\background.png"));
        background.setBounds(25, 55, 450, 454);
        frame.getContentPane().add(background);

        frame.setVisible(true);

    }
}
