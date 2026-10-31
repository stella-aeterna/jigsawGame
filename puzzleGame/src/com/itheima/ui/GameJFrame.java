package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Paths;
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
    //步数
    int step = 0;
    //创建选项下的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    //更换图片
    JMenuItem changeNumberItem = new JMenuItem("数字");
    JMenuItem changeAnimalItem = new JMenuItem("动物");
    JMenuItem changeEmojiItem = new JMenuItem("表情");

    JMenuItem accountItem = new JMenuItem("公众号");
    //图片路径


    String firstPath = "puzzleGame\\image";
    String BackgroundPath = firstPath + "\\Background\\";
    String[][] PathStr = new String[][]{
            {"\\number", firstPath + "\\number"},//\number1\number1
            {"\\emoji",firstPath+"\\emoji"},
            {"\\animal",firstPath+ "\\animal"}
    };
    //初始化为数字图片
    //默认为数字第2张
    String Path = PathStr[0][1] + PathStr[0][0] + 2 + PathStr[0][0] + 2;
    //数组，管理数据
    int[][] data = new int[4][4];
    //存储正确的数据
    int[][] win = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    public GameJFrame(){
        //界面初始化
        initJFrame();

        //菜单初始化
        initJMenuBar();

        //初始化数据（打乱）
        initData();

        //加载图片
        initImage();

        //绑定键盘
        this.addKeyListener(this);

        //显示界面，让其他的加载出来，在显示
        this.setVisible(true);
        //设置游戏的关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void change(Object source) {
        Random r = new Random();

        //  {"\\number","puzzleGame\\image\\number"},
        //  {"\\emoji","puzzleGame\\image\\emoji"},
        //  {"\\animal","puzzleGame\\image\\animal"}

        //截取当前图片的标号
        int lastIndex = Path.lastIndexOf("\\");
        String lastString = Path.substring(lastIndex);
        //更换图片(数字)
        if(source == changeNumberItem){
            int index = r.nextInt(2) + 1;
            System.out.println(lastString);
            //记录随机的标号
            String Tem = PathStr[0][0] + index;
            //判断当前的编号是否与随机编号重复，如果重复就重新随机
            while(lastString.equals(Tem)){
                index = r.nextInt(2) + 1;
                System.out.println("重新随机");
                Tem = PathStr[0][0] + index;
            }
            Path = PathStr[0][1] + Tem + Tem;
        }
        //更换图片(表情)
        else if (source == changeEmojiItem){
            int index = r.nextInt(7) + 1;
            System.out.println(lastString);
            String Tem = PathStr[1][0] + index;
            while(lastString.equals(Tem)){
                index = r.nextInt(7) + 1;
                System.out.println("重新随机");
                Tem = PathStr[1][0] + index;
            }
            Path = PathStr[1][1] + Tem + Tem;
        }
        //更换图片(动物)
        else if(source == changeAnimalItem){
            int index = r.nextInt(2) + 1;
            String Tem = PathStr[2][0] + index;
            System.out.println(lastString);
            while(Tem.equals(lastString)){
                index = r.nextInt(2) + 1;
                System.out.println("重新随机");
                Tem = PathStr[2][0] + index;
            }
            Path = PathStr[2][1] + Tem + Tem;
            initImage();
        }
        //刷新图片
        initImage();
    }

    //数组的打乱
    private void initData() {

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
        int inv = 0;
        //除去0求逆序数
        for (int i = 0; i < tempArr.length; i++) {
            if(tempArr[i] == 0){
                continue;
            }
            for (int j = i + 1; j < tempArr.length; j++) {
                if(tempArr[j] == 0){
                    continue;
                }
                if(tempArr[i] > tempArr[j])
                    inv++;
            }
        }
        for (int i = 0; i < tempArr.length; i++) {
            //代码简洁
            if(tempArr[i] == 0){
                x = i / 4;
                y = i % 4;
            }
                data[i / 4][i % 4] = tempArr[i];
        }
        //逆序数 + 空格行号(重0向下) 为奇数才有解，使用为偶数调整
        if((inv + x) % 2 == 0){
            int tem = data[x][(y + 1) % 4];
            data[x][(y + 1) % 4] = data[x][(y + 2) % 4];
            data[x][(y + 2) % 4] = tem;
        }
    }
    //初始化图片
    private void initImage() {
        //先清空已经出现的图片
        this.getContentPane().removeAll();

        //判断是否胜利
        if (victory()) {
            JLabel jLabelVictory = new JLabel(new ImageIcon("puzzleGame\\image\\win.png")) ;

            jLabelVictory.setBounds(200,300,197,73);
            this.getContentPane().add(jLabelVictory);
            this.getContentPane().repaint();

            //加载完整图片(加载最后一张图片)
            String fullImage =  Path + "All.jpg";
            JLabel jLabelAll = new JLabel(new ImageIcon(fullImage));
            jLabelAll.setBounds(47,110,480,480);
            this.getContentPane().add(jLabelAll);
        }

        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(70,68,100,27);
        stepCount.setFont(new java.awt.Font("微软雅黑", java.awt.Font.PLAIN, 20));
        this.getContentPane().add(stepCount);
        //用循环操作
        int n = data[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int number = data[i][j];
                String numberString = String.format("%02d",number);
                //创建ImageIcon图片对象
                String imagePath = Path + "_" + numberString +".png";
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
        //添加背景图片
        ImageIcon BackgroundImageIcon = new ImageIcon(BackgroundPath + "BackgroundImage.jpg");
        JLabel jLabel = new JLabel(BackgroundImageIcon);
        jLabel.setBounds(0,0,578,644);
        this.getContentPane().add(jLabel);

        //刷新界面
        this.getContentPane().repaint();
    }
    //菜单初始化
    private void initJMenuBar() {

        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面的两个选项的对象
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        JMenu changeJMenu = new JMenu("更换图片");

        //把菜单栏，选项，条目组合起来
        functionJMenu.add(changeJMenu);
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        changeJMenu.add(changeAnimalItem);
        changeJMenu.add(changeEmojiItem);
        changeJMenu.add(changeNumberItem);

        aboutJMenu.add(accountItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给每个都绑定事件
        replayItem.addMouseListener(this);
        reLoginItem.addMouseListener(this);
        closeItem.addMouseListener(this);

        changeNumberItem.addMouseListener(this);
        changeAnimalItem.addMouseListener(this);
        changeEmojiItem.addMouseListener(this);

        accountItem.addMouseListener(this);

        //给界面设置菜单
        this.setJMenuBar(jMenuBar);
    }
    //设置界面
    private void initJFrame() {

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
        if (victory()) {
            //如果胜利了，就不再可查看
            return;
        }

        int keyCode = e.getKeyCode();
        //90是z
        if(keyCode == 90){

            //清空图片
            this.getContentPane().removeAll();

            //加载边框线
            int n = win[0].length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int number = win[i][j];
                    String numberString = String.format("%02d",number);
                    String imagePath = Path + "_" + numberString +".png";
                    JLabel jLabel  = new JLabel(new ImageIcon(imagePath));
                    jLabel.setBounds(120*j + 47,120*i + 110,120,120);
                    jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    this.getContentPane().add(jLabel);
                }
            }

            //加载完整图片(加载最后一张图片)
            String fullImage =  Path + "All.jpg";
            JLabel jLabelAll = new JLabel(new ImageIcon(fullImage));
            jLabelAll.setBounds(47,110,480,480);
            this.getContentPane().add(jLabelAll);
            //加载背景图片
            ImageIcon BackgroundImageIcon = new ImageIcon(BackgroundPath + "BackgroundImage.jpg");
            JLabel jLabel = new JLabel(BackgroundImageIcon);
            jLabel.setBounds(0,0,578,644);
            this.getContentPane().add(jLabel);
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        //如果按下松开r，重新游戏,r是
        if(keyCode == 82){
            step = 0;
            initData();
            initImage();
        }

        if (victory()) {
            //如果胜利了，就不再可移动
            return;
        }

        System.out.println(keyCode);
        //38是上键，87是w
        if((keyCode == 38 || keyCode == 87) && x != 3){//上
            System.out.println("上");
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x = x + 1;
            step++;
            initImage();
        }
        //40是下键，83是s
        else if((keyCode == 40 || keyCode == 83) && x != 0){//下
            System.out.println("下");
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x = x - 1;
            step++;
            initImage();
        }
        //37是左键，65是a
        else if((keyCode == 37 || keyCode == 65) && y != 3){//左
            System.out.println("左");
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y = y + 1;
            step++;
            initImage();
        }
        //39是右键，68是d
        else if((keyCode == 39 || keyCode == 68) && y != 0){//右
            System.out.println("右");
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y = y - 1;
            step++;
            initImage();
        }
        //90是z
        else if(keyCode == 90){
            initImage();
        }
        //88是x
        else if(keyCode == 88){
            //一键还原
            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            //让x,y重新标记空白块
            x = 3;y = 3;
            initImage();
        }
        //70是f
        else if(keyCode == 70){
            //在全部图片随机
            Random r = new Random();
            //  {"\\number","puzzleGame\\image\\number"},
            //  {"\\emoji","puzzleGame\\image\\emoji"},
            //  {"\\animal","puzzleGame\\image\\animal"}
            int i = r.nextInt(3);
            //截取当前图片的标号
            int lastIndex = Path.lastIndexOf("\\");
            String lastString = Path.substring(lastIndex);
            int index = 0;
            if(i == 0)
                index = r.nextInt(2) + 1;
            else if(i == 1)
                index = r.nextInt(7) + 1;
            else if(i == 2)
                index = r.nextInt(2) + 1;
            //记录随机的标号
            String Tem = PathStr[i][0] + index;
            System.out.println(lastString);
            System.out.println(Tem);
            //判断当前的编号是否与随机编号重复，如果重复就重新随机
            while(lastString.equals(Tem)){
                i = r.nextInt(3);
                if(i == 0)
                    index = r.nextInt(2) + 1;
                else if(i == 1)
                    index = r.nextInt(7) + 1;
                else if(i == 2)
                    index = r.nextInt(2) + 1;
                System.out.println("重新随机");
                Tem = PathStr[i][0] + index;
            }
            Path = PathStr[i][1] + Tem + Tem;
            initImage();
        }
    }

    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                //有一个不同返回false
                if(data[i][j] != win[i][j])
                    return false;
            }
        }
        return true;
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
        Object source = e.getSource();
        //更换图片
        //动物,表情,数字
        if(source == changeAnimalItem || source == changeEmojiItem || source == changeNumberItem){
            change(source);
        }
        //重新游戏
        else if(source == replayItem){
            step = 0;
            initData();
            initImage();
        }
        //重新登录
        else if(source == reLoginItem){
            this.setVisible(false);
            new LoginJFrame();
        }
        //关闭游戏
        else if(source == closeItem){
            //直接关闭虚拟机
            System.exit(0);
        }
        //公众号
        else if(source == accountItem){
            JDialog jDialog = new JDialog();
            //创建按背景图片
            JLabel DialogBackgroundImage = new JLabel(new ImageIcon( BackgroundPath + "DialogBackgroundImage.jpg"));
            DialogBackgroundImage.setBounds(0,0,258,258);
            jDialog.getContentPane().add(DialogBackgroundImage);
            //设置弹窗的大小
            jDialog.setSize(300,300);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            //不关闭该弹窗，无法操作下方界面
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }
    }
    //划入
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    //划出
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
