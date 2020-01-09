package com.zjw.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FrameDemo {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        //设置大小
//        frame.setSize(400,300);
        //设置窗口位置
//        frame.setLocation(100,300);
        //设置窗口位置、大小
        frame.setBounds(100, 300, 400, 300);
        //设置标题
        frame.setTitle("HelloWorld");

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //设置按钮
//        Button button = new Button("我");
//        button.setSize(10,20);
//        frame.add(button);
        TextField textField = new TextField(20);
        JButton jButton = new JButton("按钮");
        TextArea textArea = new TextArea(10, 40);

        //对按钮加动作事件
//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String fieldText = textField.getText();
//                textField.setText("");
//                textArea.append(fieldText+"\r\n");
//                textField.requestFocus();
//            }
//        });

        jButton.addMouseListener(new MouseAdapter() {

            //单击后
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                frame.setBackground(Color.GREEN);
//            }

            //按下鼠标
//            @Override
//            public void mousePressed(MouseEvent e) {
//                frame.setBackground(Color.YELLOW);
//            }

            //释放鼠标
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                frame.setBackground(Color.GREEN);
//            }

            //鼠标进入按钮
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                frame.setBackground(Color.GREEN);
//            }

            //鼠标离开按钮
//            @Override
//            public void mouseExited(MouseEvent e) {
//                frame.setBackground(Color.WHITE);
//            }

        });

        //本来要限制文本框只能输入数字。失败
//        textField.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                char keyChar = e.getKeyChar();
//                if (!(keyChar >= '0' && keyChar <= '9')) {
//                    e.consume();
//                }
//            }
//        });

        frame.add(textField);
        frame.add(jButton);
        frame.add(textArea);

        //设置菜单栏
        frame.setJMenuBar(getJMenuBar());
        //设置图标
        frame.setIconImage(getImage());
        //设置居中
        setJFrameCenter(frame);

        frame.setLayout(new FlowLayout());

        //设置可见性
        frame.setVisible(true);
    }

    public static JMenuBar getJMenuBar() {
        //菜单栏
        JMenuBar jMenuBar = new JMenuBar();

        //菜单
        JMenu 文件 = new JMenu("文件");
        JMenu 打开文件 = new JMenu("打开文件");

        //菜单项
        JMenuItem 退出系统 = new JMenuItem("退出系统");
        JMenuItem 打开记事本 = new JMenuItem("打开记事本");

        打开文件.add(打开记事本);

        文件.add(打开文件);
        文件.add(退出系统);

        jMenuBar.add(文件);

        退出系统.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        打开记事本.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime runtime = Runtime.getRuntime();
                try {
                    runtime.exec("notepad");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        return jMenuBar;
    }

    public static Image getImage() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Image image = defaultToolkit.getImage("src\\main\\resources\\img\\3.png");
        return image;
    }

    public static void setJFrameCenter(JFrame jFrame) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int height = (int) (screenSize.getHeight() - jFrame.getHeight()) / 2;
        int width = (int) (screenSize.getWidth() - jFrame.getWidth()) / 2;
        jFrame.setLocation(width,height);

    }


}
