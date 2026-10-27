package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener , MouseListener {
    //JFrame 界面 ，窗体
    //规定：GameJFrame这个界面表示游戏的主界面
    //界面的宽高
    private static final int  width = 590;
    private static final int  height = 703;
    //空白块的位置
    int x;
    int y;
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
        this.addKeyListener(this);

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
            if(tempArr[i] == 0){
                x = i / 4;
                y = i % 4;
            }
            Arr[i / 4][i % 4] = tempArr[i];
        }
    }
    //初始化图片
    private void initImage() {
        //先清空已经出现的图片
        this.getContentPane().removeAll();

        //用循环操作
        int n = Arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int number = Arr[i][j];
                String numberString = String.format("%02d",number);
                //创建ImageIcon图片对象
                String imagePath = "puzzleGame\\image\\number\\number1\\number1_"+ numberString +".png";
                //String imagePath = "puzzleGame\\image\\animal\\animal1\\animal1_" + numberString +".png";
                ImageIcon icon = new ImageIcon(imagePath);
                //创建JLabel的对象（管理容器）
                JLabel jLabel  = new JLabel(icon);
                //设置图像位置

                jLabel.setBounds(120*j + 47,120*i + 110,120,120);
                //给图片加边框
                //0:表示让图片凸起   可以用BevelBorder.RAISED
                //1:表示让图片凹下去 可以用BevelBorder.LOWERED
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //先获取JFrame中的隐藏容器,再添加
                this.getContentPane().add(jLabel);
            }
        }

        //先添加的会覆盖后添加的
        ImageIcon BackgroundImageIcon = new ImageIcon("puzzleGame\\image\\Background\\BackgroundImage.jpg");
        JLabel jLabel = new JLabel(BackgroundImageIcon);
        jLabel.setBounds(0,0,578,644);
        this.getContentPane().add(jLabel);

        //刷新界面
        this.getContentPane().repaint();
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
        //38是上键，87是w
        if((keyCode == 38 || keyCode == 87) && x != 3){//上
            System.out.println("上");
            Arr[x][y] = Arr[x + 1][y];
            Arr[x + 1][y] = 0;
            x = x + 1;
            initImage();
        }
        //40是下键，83是s
        else if((keyCode == 40 || keyCode == 83) && x != 0){//下
            System.out.println("下");
            Arr[x][y] = Arr[x - 1][y];
            Arr[x - 1][y] = 0;
            x = x - 1;
            initImage();
        }
        //37是左键，65是a
        else if((keyCode == 37 || keyCode == 65) && y != 3){//左
            System.out.println("左");
            Arr[x][y] = Arr[x][y + 1];
            Arr[x][y + 1] = 0;
            y = y + 1;
            initImage();
        }
        //39是右键，68是d
        else if((keyCode == 39 || keyCode == 68) && y != 0){//右
            System.out.println("右");
            Arr[x][y] = Arr[x][y - 1];
            Arr[x][y - 1] = 0;
            y = y - 1;
            initImage();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
