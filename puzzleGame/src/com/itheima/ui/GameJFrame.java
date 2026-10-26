package com.itheima.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    //JFrame 界面 ，窗体
    //规定：GameJFrame这个界面表示游戏的主界面
    private static final int  width = 480;
    private static final int  height = 480;
    public GameJFrame(){
        //界面初始化
        initJFrame();

        //菜单初始化
        initJMenuBar();

        //初始化图片
        initImage();


        //显示界面，让其他的加载出来，在显示
        this.setVisible(true);
        //设置游戏的关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void initImage() {
        //初始化图片
        //创建ImageIcon图片对象
        ImageIcon icon = new ImageIcon("puzzleGame\\image\\animal\\animal1\\animal1_01.png");
        //创建JLabel的对象（管理容器）
        JLabel jLabel1 = new JLabel(icon);
        //设置图像位置
        jLabel1.setBounds(0,0,120,120);
        //把管理容器添加到界面
        //this.add(jLabel);
        //先获取JFrame中的隐藏容器,再添加
        this.getContentPane().add(jLabel1);

    }

    private void initJMenuBar() {
        //菜单初始化
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面的两个选项的对象
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //创建选项下的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        //把菜单栏，选项，条目组合起来
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面
        //设置宽高
        this.setSize(width,height);
        //设置标题
        this.setTitle("拼图游戏");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面位置
        this.setLocationRelativeTo(null);
        //取消默认放置，才能按照XY轴的形式添加组件
        this.setLayout(null);
    }
}
