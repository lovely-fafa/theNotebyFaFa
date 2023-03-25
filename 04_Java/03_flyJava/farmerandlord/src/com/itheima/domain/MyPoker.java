package com.itheima.domain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPoker extends JLabel implements MouseListener {

    // 属性
    // 1. 名字
    private String name;

    // 2. 正反面
    private boolean up;

    // 3. 是否可以被点击
    private boolean canCLike = false;

    // 4. 当前状态
    // 如果是没有被点击的状态，此时被点击了，会执行弹起的操作
    // 如果是已经被点击的状态，此时被点击了，会执行降落的操作
    private boolean clicked = false;

    // 肯定只能用有参构造
    public MyPoker(String name, boolean up) {
        this.name = name;
        this.up = up;

        if (this.up) {
            // 显示正面
            turnFront();
        } else {
            turnRear();
            // 显示反面
        }

        // 设置宽高
        this.setSize(71, 96);
        // 显示
        this.setVisible(true);
        // 添加监听
        this.addMouseListener(this);
    }


    public MyPoker(String name, boolean up, boolean canCLike, boolean clicked) {
        this.name = name;
        this.up = up;
        this.canCLike = canCLike;
        this.clicked = clicked;
    }

    // 显示正面
    public void turnFront() {
        this.setIcon(new ImageIcon("farmerandlord\\image\\poker\\" + name +".png"));
        this.up = true;
    }

    // 显示反面
    public void turnRear() {
        this.setIcon(new ImageIcon("farmerandlord\\image\\poker\\rear.png"));
        this.up = false;
    }

    // 点击
    @Override
    public void mouseClicked(MouseEvent e) {
        // 是否可以点击
        if (canCLike) {
            int step = 0;  // 位移像素
            // 升起还是降落
            if (clicked) {
                // 降落：y 增加 20 px
                step = 20;
            } else {
                // 升起：y 减少 20 px
                step = -20;
            }
            // 改 click 的值 直接取反
            clicked = !clicked;
            // 修改牌的位置
            Point location = this.getLocation();
            this.setLocation(location.x, location.y + step);
        }
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

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return up
     */
    public boolean isUp() {
        return up;
    }

    /**
     * 设置
     * @param up
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * 获取
     * @return canCLike
     */
    public boolean isCanCLike() {
        return canCLike;
    }

    /**
     * 设置
     * @param canCLike
     */
    public void setCanCLike(boolean canCLike) {
        this.canCLike = canCLike;
    }

    /**
     * 获取
     * @return clicked
     */
    public boolean isClicked() {
        return clicked;
    }

    /**
     * 设置
     * @param clicked
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public String toString() {
        return "MyPoker{name = " + name + ", up = " + up + ", canCLike = " + canCLike + ", clicked = " + clicked + "}";
    }
}
