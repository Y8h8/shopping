package com.main;

import com.bean.People;
import com.tool.IO;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends People {
    public  People Login() {
        People people = new People();
        // 创建一个新的JFrame实例作为主窗口
        JFrame jf = new JFrame("登录界面");

        // 设置窗口尺寸
        jf.setSize(400, 250);

        // 设置关闭操作为退出应用程序
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建标签并添加到窗口中
        JLabel usernameLabel = new JLabel("用户名:");
        JLabel passwordLabel = new JLabel("密码:");
        JLabel usertypeLabel = new JLabel("输入数字:1.商家\t2.用户");

        // 创建文本框用于输入用户名和密码
        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        JTextField usertypeField = new JTextField(10);




        // 使用GridLayout布局管理器
        JPanel panel = new JPanel(new GridLayout(4, 2));



        // 将面板添加到窗口中
        jf.add(panel);

        // 设置窗口居中显示
        jf.setLocationRelativeTo(null);

        // 显示窗口
        jf.setVisible(true);

        // 创建登录按钮，并为其设置事件监听器（这里只是打印出登录信息）
        JButton loginButton = new JButton("登录/注册");

        // 将所有组件添加到面板上
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(usertypeLabel);
        panel.add(usertypeField);
        // 空白占位符
        panel.add(new JLabel());
        panel.add(loginButton);


        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            int type = Integer.parseInt(usertypeField.getText());
            people.setName(username);
            people.setPassword(password);
            people.setType(type-1);

            jf.dispose();
        });

        return people;
    }
}
