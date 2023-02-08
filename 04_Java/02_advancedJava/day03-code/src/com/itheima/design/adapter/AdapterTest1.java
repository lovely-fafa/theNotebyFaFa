package com.itheima.design.adapter;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdapterTest1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("键盘按下了...");
            }
        });

        frame.setVisible(true);
    }
}
