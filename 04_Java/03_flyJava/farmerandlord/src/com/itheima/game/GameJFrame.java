package com.itheima.game;

import com.itheima.domain.MyPoker;
import com.itheima.domain.Poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GameJFrame extends JFrame implements ActionListener {

    public static Container container = null;  // 容器
    // 管理抢地主和不抢两个按钮
    JButton[] landlord = new JButton[2];  // [null, null]
    // 管理出牌和不出牌两个按钮
    JButton[] publishCard = new JButton[2];

    JLabel dizhu;
    // 集合嵌套
    // 每一个玩家当前要出的牌
    ArrayList<ArrayList<MyPoker>> currentList = new ArrayList<>();
    // 集合嵌套
    // 每一个玩家手上出的牌
    ArrayList<ArrayList<MyPoker>> playerList = new ArrayList<>();
    // 底牌
    ArrayList<MyPoker> lordList = new ArrayList<>();
    // 牌盒
    ArrayList<MyPoker> pokerList = new ArrayList();
    // 倒计时
    JTextField[] time = new JTextField[3];

    public GameJFrame() {
        //设置任务栏的图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("farmerandlord\\image\\poker\\dizhu.png"));
        //设置界面
        initJframe();
        //添加组件
        initView();
        //界面显示出来
        //先展示界面再发牌，因为发牌里面有动画，界面不展示出来，动画无法展示
        this.setVisible(true);

        //初始化牌
        //准备牌，洗牌，发牌，排序
        initCard();
        //打牌之前的准备工作
        //展示抢地主和不抢地主两个按钮并且再创建三个集合用来装三个玩家准备要出的牌
        initGame();
    }

    //初始化牌（准备牌，洗牌，发牌，排序）
    public void initCard() {
		// 准备牌
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 13; j++) {
                if ((i == 5) && (j > 2)) {
                    break;
                } else {
                    MyPoker poker = new MyPoker(i + "-" + j, false);
                    poker.setLocation(350, 150);
                    pokerList.add(poker);
                    container.add(poker);
                }
            }
        }

        // 洗牌
        Collections.shuffle(pokerList);

        // 发牌
        ArrayList<MyPoker> player0 = new ArrayList<>();
        ArrayList<MyPoker> player1 = new ArrayList<>();
        ArrayList<MyPoker> player2 = new ArrayList<>();

        for (int i = 0; i < pokerList.size(); i++) {
            if (i <= 2) {
                Common.move(pokerList.get(i), pokerList.get(i).getLocation(), new Point(270 + (75 * i), 10));
                lordList.add(pokerList.get(i));
            }
            if (i % 3 == 0) {
                Common.move(pokerList.get(i), pokerList.get(i).getLocation(), new Point(50, 60 + i * 5));
                player0.add(pokerList.get(i));
            } else if (i % 3 == 1) {
                Common.move(pokerList.get(i), pokerList.get(i).getLocation(), new Point(100 + i * 7, 450));
                player1.add(pokerList.get(i));
            } else {
                Common.move(pokerList.get(i), pokerList.get(i).getLocation(), new Point(700, 60 + i * 5));
                player2.add(pokerList.get(i));
            }

            // 当前牌置于顶层
            container.setComponentZOrder(pokerList.get(i), i);
        }

        playerList.add(player0);
        playerList.add(player1);
        playerList.add(player2);

        // 排序
        for (int i = 0; i < 3; i++) {
            order(playerList.get(i));
            Common.rePosition(this, playerList.get(i), i);
        }
    }

    //排序
    public void order(ArrayList<MyPoker> list) {
        //自己练习
        Collections.sort(list, new Comparator<MyPoker>() {
            @Override
            public int compare(MyPoker o1, MyPoker o2) {
                int color1 = Integer.parseInt(o1.getName().substring(0, 1));
                int value1 = getValue(o1);

                int color2 = Integer.parseInt(o2.getName().substring(0, 1));
                int value2 = getValue(o2);

                int flag = value2 - value1;

                if (flag == 0) {
                    return color2 - color1;
                } else {
                    return flag;
                }
            }
        });
    }

    //获取每一张牌的价值
    public int getValue(MyPoker poker) {
       //自己练习
        String name = poker.getName();

        int color = Integer.parseInt(name.substring(0, 1));
        int value = Integer.parseInt(name.substring(2));

        if (color == 5) {
            return value + 100;
        }
        if (value == 1) {
            return value + 20;
        }
        if (value == 2) {
            return  value + 30;
        }

        return value;
    }


    //打牌之前的准备工作
    private void initGame() {
        //创建三个集合用来装三个玩家准备要出的牌
        for (int i = 0; i < 3; i++) {
            ArrayList<MyPoker> list = new ArrayList<>();
            //添加到大集合中方便管理
            currentList.add(list);
        }

        //展示抢地主和不抢地主两个按钮
        landlord[0].setVisible(true);
        landlord[1].setVisible(true);

        //展示自己前面的倒计时文本
        for (JTextField field : time) {
            field.setText("倒计时30秒");
            field.setVisible(true);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //添加组件
    public void initView() {
        //创建抢地主的按钮
        JButton robBut = new JButton("抢地主");
        //设置位置
        robBut.setBounds(320, 400, 75, 20);
        //添加点击事件
        robBut.addActionListener(this);
        //设置隐藏
        robBut.setVisible(false);
        //添加到数组中统一管理
        landlord[0] = robBut;
        //添加到界面中
        container.add(robBut);

        //创建不抢的按钮
        JButton noBut = new JButton("不     抢");
        //设置位置
        noBut.setBounds(420, 400, 75, 20);
        //添加点击事件
        noBut.addActionListener(this);
        //设置隐藏
        noBut.setVisible(false);
        //添加到数组中统一管理
        landlord[1] = noBut;
        //添加到界面中
        container.add(noBut);

        //创建出牌的按钮
        JButton outCardBut = new JButton("出牌");
        outCardBut.setBounds(320, 400, 60, 20);
        outCardBut.addActionListener(this);
        outCardBut.setVisible(false);
        publishCard[0] = outCardBut;
        container.add(outCardBut);

        //创建不要的按钮
        JButton noCardBut = new JButton("不要");
        noCardBut.setBounds(420, 400, 60, 20);
        noCardBut.addActionListener(this);
        noCardBut.setVisible(false);
        publishCard[1] = noCardBut;
        container.add(noCardBut);


        //创建三个玩家前方的提示文字：倒计时
        //每个玩家一个
        //左边的电脑玩家是0
        //中间的自己是1
        //右边的电脑玩家是2
        for (int i = 0; i < 3; i++) {
            time[i] = new JTextField("倒计时:");
            time[i].setEditable(false);
            time[i].setVisible(false);
            container.add(time[i]);
        }
        time[0].setBounds(140, 230, 60, 20);
        time[1].setBounds(374, 360, 60, 20);
        time[2].setBounds(620, 230, 60, 20);

        //创建地主图标
        dizhu = new JLabel(new ImageIcon("images/dizhu.png"));
        dizhu.setVisible(false);
        dizhu.setSize(40, 40);
        container.add(dizhu);
    }

    //设置界面
    public void initJframe() {
        //设置标题
        this.setTitle("斗地主");
        //设置大小
        this.setSize(830, 620);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //获取界面中的隐藏容器，以后直接用无需再次调用方法获取了
        container = this.getContentPane();
        //取消内部默认的居中放置
        container.setLayout(null);
        //设置背景颜色
        container.setBackground(Color.LIGHT_GRAY);
    }
}