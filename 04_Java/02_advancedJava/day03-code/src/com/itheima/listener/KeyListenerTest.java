package com.itheima.listener;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("键盘按下了...");
                int keyCode = e.getKeyCode();
                if (keyCode == 37) {
                    System.out.println("左");
                } else if (keyCode == 38) {
                    System.out.println("上");
                } else if (keyCode == 39) {
                    System.out.println("右");
                } else if (keyCode == 40) {
                    System.out.println("下");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        frame.setVisible(true);
    }
}
