package com.itheima.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    public MyJFrame3() {
        this.setSize(600,600);
        this.setTitle("test3");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        //创建按钮

        //jtb1.setBounds(0,0,200,200);
        this.addKeyListener(this);

        //把按钮添加到界面
        //this.getContentPane().add(jtb1);

        this.setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    //按下不松
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }
    //松开按键
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");
        int code = e.getKeyCode();
        System.out.println(code);
    }
}
