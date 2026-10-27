package com.itheima.test;

import javax.swing.*;

public class Test {
    public static void main(String[] args){
        //创建一个游戏的主界面
        //JavaBean类描述界面的
        //属性（长和宽）   行为
        //上下左右移动
        //一键通关
        //查看最终效果
        //等等
        JFrame gameJframe = new JFrame();
        gameJframe.setSize(600,680);
        gameJframe.setVisible(true);//展示界面

        //创建一个登录界面
        //获取用户输入的用户名
        //获取用户输入的密码
        //获取用户输入的验证码
        //比较用户名，密码，验证码
        JFrame loginJframe = new JFrame();
        loginJframe.setSize(480,500);
        loginJframe.setVisible(true);

        //创建一个注册界面
        //获取用户输入的用户名
        //获取用户输入的密码
        //获取用户输入的验证码
        //用户是否注册
        JFrame registerJframe = new JFrame();
        registerJframe.setSize(480,500);
        registerJframe.setVisible(true);
    }
}
