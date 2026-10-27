package com.itheima.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {
    //与Test2的另一种实现
    JButton jtb1 = new JButton("MyFrame中的点击1");
    JButton jtb2 = new JButton("MyFrame中的点击2");
    public MyJFrame() {
        this.setSize(600,600);
        this.setTitle("test");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        //创建按钮

        jtb1.setBounds(0,0,200,50);
        jtb1.addActionListener(this);

        jtb2.setBounds(0,100,200,50);
        jtb2.addActionListener(this);

        //把按钮添加到界面
        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //可以对当前的按钮作判断
        //获取当前操作的按钮对象
        Object source = e.getSource();
        if(source == jtb1){
            System.out.println("111");
            jtb1.setSize(100,100);
        }else if(source == jtb2){
            Random r = new Random();
            jtb2.setLocation(r.nextInt(400),r.nextInt(400));
        }

    }
}
