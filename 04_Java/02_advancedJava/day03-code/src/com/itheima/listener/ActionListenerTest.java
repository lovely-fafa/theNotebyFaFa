package com.itheima.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton btn = new JButton("按钮");
        btn.setBounds(0, 0, 50, 50);
        frame.getContentPane().add(btn);

        // 匿名内部类
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("我被点了...");
            }
        });

        frame.setVisible(true);
    }
}
