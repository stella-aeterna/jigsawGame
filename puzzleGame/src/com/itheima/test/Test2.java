package com.itheima.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test2 {
    public static void main(String[] args) {
        //创建窗体对象
        JFrame jFrame = new JFrame();
        //设置窗体大小
        jFrame.setSize(500,500);
        //设置页面置顶
        jFrame.setAlwaysOnTop(true);
        //设置初始页面位置,居中
        jFrame.setLocationRelativeTo(null);
        //这种关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置
        jFrame.setLayout(null);

        //KeyListener表示键盘监听
        //MouseListener表示鼠标监听
        //ActionListener表示动作监听(鼠标左键，空格)

        //创建按钮对象
        JButton jtb1 = new JButton("点击");
        //设置按钮的初始位置与大小
        jtb1.setBounds(0,0,100,50);
        //因为是测试，只调用一次，使用直接用匿名内部类
        ActionListener MyActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了");
            }
        };
        jtb1.addActionListener(MyActionListener);
        jFrame.getContentPane().add(jtb1);

        JButton jtb2 = new JButton("点击点击");
        jtb2.setBounds(100,0,100,50);




        //界面显示
        jFrame.setVisible(true);
    }
}
