package com.itheima.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MyJFrame2 extends JFrame implements MouseListener {
    JButton jtb1 = new JButton("MyFrame2中的点击1");
    public MyJFrame2() {
        this.setSize(600,600);
        this.setTitle("test2");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        //创建按钮

        jtb1.setBounds(0,0,200,200);
        jtb1.addMouseListener(this);

        //把按钮添加到界面
        this.getContentPane().add(jtb1);

        this.setVisible(true);
    }

    //单击
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }
    //按下
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下");
    }
    //松开
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }
    //划入
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }
    //划出
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
