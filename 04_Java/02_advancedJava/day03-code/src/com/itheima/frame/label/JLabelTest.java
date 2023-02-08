package com.itheima.frame.label;

import javax.swing.*;

public class JLabelTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel jL1 = new JLabel("听君一席话");
        jL1.setBounds(50, 50, 100, 100);
        frame.getContentPane().add(jL1);

        JLabel jL2 = new JLabel("胜读十年书");
        jL2.setBounds(150, 50, 100, 100);
        frame.getContentPane().add(jL2);

        ImageIcon icon = new ImageIcon("E:\\程序员\\发发的笔记\\advancedJava\\day03-code\\src\\com\\itheima\\frame\\label\\pink.jpg");
        JLabel imgLabel = new JLabel(icon);
        imgLabel.setBounds(250, 50, 640, 640);

        frame.getContentPane().add(imgLabel);

        frame.setVisible(true);
    }
}
