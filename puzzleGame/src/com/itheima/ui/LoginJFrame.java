package com.itheima.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //登录的窗体
    private static final int  width = 480;
    private static final int  height = 480;
    public LoginJFrame() {
        //设置宽高
        this.setSize(width, height);
        //设置标题
        this.setTitle("拼图游戏");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面位置
        this.setLocationRelativeTo(null);
        //设置游戏的关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //初始化界面


        //显示界面，让其他的加载出来，在显示
        this.setVisible(true);
    }

}
