package com.itheima.frame;

import javax.swing.*;

public class JFrameTest {
    public static void main(String[] args) {
        // 创建窗体对象
        JFrame frame = new JFrame();

        // 设置窗体大小
        frame.setSize(500, 300);

        // 修改窗口关闭模式
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 设置窗体标题
        frame.setTitle("这是我的第一个窗体...");

        // 设置窗体可见 这句放最后
        frame.setVisible(true);
    }
}
