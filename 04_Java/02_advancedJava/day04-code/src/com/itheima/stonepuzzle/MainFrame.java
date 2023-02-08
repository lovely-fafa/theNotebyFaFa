package com.itheima.stonepuzzle;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class MainFrame extends JFrame implements KeyListener {
    int[][] data = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    // 统计步数 成员变量默认值 0 所以没有赋值
    int  countStep;

    // 0 号元素坐标
    int row;
    int col;


    public MainFrame() {

        // 窗体对象.addKeyListener(KeyListener实现类对象);
        // this：当前类对象
        // 1) 窗体对象
        // 2) KeyListener 实现类对象
        this.addKeyListener(this);

        initFrame();
        initData();
        printView();

        setVisible(true);
    }

    /**
     * 初始化数组（打乱二维数组）
     */
    public void initData() {
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int x = r.nextInt(4);
                int y = r.nextInt(4);

                int temp = data[i][j];
                data[i][j] = data[x][y];
                data[x][y] = temp;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (data[i][j] == 0){
                    row = i;
                    col = j;
                }
            }
        }
    }

    /**
     * 此方法用于初始化窗体
     */
    public void initFrame() {
        setSize(514, 595);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("石头迷阵 V1.0");
        setAlwaysOnTop(true);  // 置顶
        setLocationRelativeTo(null);
        setLayout(null);
    }

    /**
     * 此方法用于绘制游戏界面
     */
    public void printView() {

        getContentPane().removeAll(); // 移除现有的

        // 绘制胜利
        if (victory()) {
            JLabel winLabel = new JLabel(new ImageIcon("E:\\程序员\\发发的笔记\\advancedJava\\day04-code" +
                    "\\src\\com\\itheima\\stonepuzzle\\image\\win.png"));
            winLabel.setBounds(124, 230, 266, 88);
            getContentPane().add(winLabel);
        }

        // 重新开始游戏
        JButton btn = new JButton("重新游戏");
        btn.setBounds(350, 20, 100, 20);
        getContentPane().add(btn);
        btn.setFocusable(false);  // 取消焦点
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countStep = 0;
                initData();
                printView();
            }
        });

        // 记录步数
        JLabel countStepLabel = new JLabel("步数为：" + countStep);
        countStepLabel.setBounds(50, 20, 100, 20);
        getContentPane().add(countStepLabel);


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel imageLabel = new JLabel(new ImageIcon("E:\\程序员\\发发的笔记\\advancedJava" +
                        "\\day04-code\\src\\com\\itheima\\stonepuzzle\\image\\" + data[i][j] + ".png"));
                imageLabel.setBounds(50 + 100 * j, 90 + 100 * i, 100, 100);
                getContentPane().add(imageLabel);
            }
        }

        JLabel background = new JLabel(new ImageIcon("E:\\程序员\\发发的笔记\\advancedJava\\day04-code" +
                "\\src\\com\\itheima\\stonepuzzle\\image\\background.png"));
        background.setBounds(25, 30, 450, 484);
        getContentPane().add(background);

        getContentPane().repaint();  // 刷新
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        move(keyCode);
        printView();
    }

    /**
     * 此方法用于处理移动业务
     * @param keyCode
     */
    private void move(int keyCode) {

        if (victory()) {
            return;
        }

        if (keyCode == 37) {
            if (col == 3) {
                return;
            }

            // 空白块和右边数据做交换
            int temp = data[row][col];
            data[row][col] = data[row][col + 1];
            data[row][col + 1] = temp;
            col ++;

        } else if (keyCode == 38) {
            if (row == 3) {
                return;
            }

            int temp = data[row][col];
            data[row][col] = data[row + 1][col];
            data[row + 1][col] = temp;
            row ++;

        } else if (keyCode == 39) {
            if (col == 0) {
                return;
            }

            int temp = data[row][col];
            data[row][col] = data[row][col - 1];
            data[row][col - 1] = temp;
            col --;

        } else if (keyCode == 40) {
            if (row == 0) {
                return;
            }

            int temp = data[row][col];
            data[row][col] = data[row - 1][col];
            data[row - 1][col] = temp;
            row --;

        } else if (keyCode == 90) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
        }

        countStep ++;
    }

    private boolean victory() {


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
