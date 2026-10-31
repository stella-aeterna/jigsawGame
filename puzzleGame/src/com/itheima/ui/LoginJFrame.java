package com.itheima.ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginJFrame extends JFrame implements MouseListener {
    //登录的窗体
    private static final int  width = 483;
    private static final int  height = 427;
    public LoginJFrame() {
        //初始化界面
        initJFrame();
        //加载输入框
        initView();
        //加载图片
        initImage();
        //显示界面，让其他的加载出来，在显示
        this.setVisible(true);
        //设置游戏的关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initView() {
        JTextField userName = new JTextField();
        userName.setBounds(170,130,200,20);
        this.getContentPane().add(userName);
        JTextField password = new JTextField();
        password.setBounds(170,180,200,20);
        this.getContentPane().add(password);
        JTextField code = new JTextField();
        code.setBounds(170,230,100,20);
        this.getContentPane().add(code);
    }

    private void initImage() {
        //用户名图片
        JLabel jLabel = new JLabel(new ImageIcon("puzzleGame\\image\\login\\用户名.png"));
        jLabel.setBounds(100,130,47,17);
        this.getContentPane().add(jLabel);
        //密码图片
        jLabel = new JLabel(new ImageIcon("puzzleGame\\image\\login\\密码.png"));
        jLabel.setBounds(100,180,32,16);
        this.getContentPane().add(jLabel);
        //验证码图片
        jLabel = new JLabel(new ImageIcon("puzzleGame\\image\\login\\验证码.png"));
        jLabel.setBounds(100,230,52,21);
        this.getContentPane().add(jLabel);
        //登录图片
        jLabel = new JLabel(new ImageIcon("puzzleGame\\image\\login\\登录按钮.png"));
        jLabel.setBounds(80,280,128,47);
        this.getContentPane().add(jLabel);
        JLabel LoginJLabel = new JLabel(new ImageIcon("puzzleGame\\image\\login\\登录按下.png"));
        LoginJLabel.setBounds(80,280,128,47);
        this.getContentPane().add(LoginJLabel);

        //注册图片
        jLabel = new JLabel(new ImageIcon("puzzleGame\\image\\login\\注册按钮.png"));
        jLabel.setBounds(270,280,128,47);
        this.getContentPane().add(jLabel);

        JLabel RegisterJLabel = new JLabel(new ImageIcon("puzzleGame\\image\\login\\注册按下.png"));
        RegisterJLabel.setBounds(270,280,128,47);
        this.getContentPane().add(RegisterJLabel);

        //背景图片
        jLabel = new JLabel(new ImageIcon("puzzleGame\\image\\login\\background.png"));
        jLabel.setBounds(0,0,470,390);
        this.getContentPane().add(jLabel);
    }

    private void initJFrame() {
        //设置宽高
        this.setSize(width, height);
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
