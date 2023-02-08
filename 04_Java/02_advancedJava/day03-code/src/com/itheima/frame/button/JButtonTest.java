package com.itheima.frame.button;

import javax.swing.*;

public class JButtonTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 取消默认窗体布局
        // 随后需要指定布局
        frame.setLayout(null);

        // 1. 创建按钮对象
        JButton btn = new JButton("点我呀~~~");
        // 设置摆放位置
        btn.setBounds(50, 50, 100, 100);

        // 2. 将按钮对象添加给窗体的 面板对象
        frame.getContentPane().add(btn);

        frame.setVisible(true);
    }
}
