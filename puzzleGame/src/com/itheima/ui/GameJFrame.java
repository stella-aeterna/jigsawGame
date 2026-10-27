package com.itheima.ui;

import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame {
    //JFrame 界面 ，窗体
    //规定：GameJFrame这个界面表示游戏的主界面
    //界面的宽高
    private static final int  width = 495;
    private static final int  height = 540;
    //数组，管理数据
    int[][] Arr = new int[4][4];
    public GameJFrame(){
        //界面初始化
        initJFrame();

        //菜单初始化
        initJMenuBar();

        //初始化数据（打乱）
        initData();

        //初始化图片
        initImage();


        //显示界面，让其他的加载出来，在显示
        this.setVisible(true);
        //设置游戏的关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void initData() {
        //数组的打乱
        int[] tempArr = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int tem = tempArr[index];
            tempArr[index] = tempArr[i];
            tempArr[i] = tem;
        }
        //代码利于理解
//        int k = 0;
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                Arr[i][j] = tempArr[k++];
//            }
//        }
        for (int i = 0; i < tempArr.length; i++) {
            //代码简洁
            Arr[i / 4][i % 4] = tempArr[i];
        }
    }

    private void initImage() {
//        //初始化图片
//        //创建ImageIcon图片对象
//        ImageIcon icon = new ImageIcon("puzzleGame\\image\\animal\\animal1\\animal1_01.png");
//        //创建JLabel的对象（管理容器）
//        JLabel jLabel1 = new JLabel(icon);
//        //设置图像位置
//        jLabel1.setBounds(0,0,120,120);
//        //把管理容器添加到界面
//        //this.add(jLabel);
//        //先获取JFrame中的隐藏容器,再添加
//        this.getContentPane().add(jLabel1);
        //用循环操作
        int n = 4;
        int numberInt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String numberString = String.format("%02d",numberInt);
                String imagePath = "puzzleGame\\image\\animal\\animal1\\animal1_" + numberString +".png";
                ImageIcon icon = new ImageIcon(imagePath);
                JLabel jLabel  = new JLabel(icon);
                jLabel.setBounds(120*j,120*i,120,120);
                this.getContentPane().add(jLabel);
                numberInt++;
            }
        }
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
