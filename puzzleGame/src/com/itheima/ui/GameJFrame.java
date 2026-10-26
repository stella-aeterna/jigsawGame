package com.itheima.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    //JFrame 界面 ，窗体
    //规定：GameJFrame这个界面表示游戏的主界面
    private static final int  width = 480;
    private static final int  height = 480;
    public GameJFrame(){
        this.setSize(width,height);
        this.setVisible(true);//this表示当前的地址值
    }
}
