/*package com.main;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    protected static void createAndShowGUI() {
        JButton b1 = new JButton("菜单");
        JButton b2 = new JButton("订单");
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Menu");
        f.setSize(350, 300);
        f.setLocation(300, 200);
        f.setLayout(new FlowLayout());
        f.add(b1);
        f.add(b2);
        f.setVisible(true);
        final JLabel label = new JLabel();
        final JDialog dialog1 = new JDialog(f,"菜单");
        final JDialog dialog2 = new JDialog(f,"订单");
        dialog1.setSize(220,150);
        dialog1.setLocation(350,250);
        dialog1.setLayout(new FlowLayout());
        final JButton b3 = new JButton("确定");
        dialog1.add(b3);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog1.setModal(false);
                if (dialog1.getComponents().length == 1){
                    dialog1.add(label);
                }
                label.setText("菜单");
                JLabel jL1=new JLabel("欢迎光临");
                JLabel jL2=new JLabel("欢迎光临1");
                Container winContainer=dialog1.getContentPane();
                winContainer.add(jL1);
                winContainer.add(jL2);
                dialog1.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog2.setModal(false);
                if (dialog2.getComponents().length == 1){
                    dialog2.add(label);
                }
                label.setText("订单");
                dialog2.setVisible(true);
            }
        });
    }

    /*public static class TanChu extends JFrame {
        private JPopupMenu popupMenu;

        public TanChu() {
            //创建一个JPopupMenu菜单
            popupMenu = new JPopupMenu();
            //创建三个JMenuItem菜单项
            JMenuItem refreshItem = new JMenuItem("refresh");
            JMenuItem createItem = new JMenuItem("create");
            JMenuItem exitItem = new JMenuItem("exit");
            //为exitItem菜单项添加事件监听器
            exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            //向JPopupMenu菜单添加菜单项
            popupMenu.add(refreshItem);
            popupMenu.add(createItem);
            popupMenu.addSeparator();
            popupMenu.add(exitItem);
            //向JFrame窗口添加clicked鼠标事件监听器
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //通过值匹配，当点击右键的时候，显示JPopupMenu菜单
                    if (e.getButton() == e.BUTTON3) {
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            });
            this.setSize(300, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }*/
    //public static void main(String[] args) {
      //  SwingUtilities.invokeLater(Menu::createAndShowGUI);
        /*new TanChu();*/
    //}
//}
package com.main;

import javax.swing.*;
import java.awt.*;

public class LoginUI {
    public  void Login() {
        // 创建一个新的JFrame实例作为主窗口
        JFrame jf = new JFrame("登录界面");

        // 设置窗口尺寸
        jf.setSize(400, 250);

        // 设置关闭操作为退出应用程序
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建标签并添加到窗口中
        JLabel usernameLabel = new JLabel("用户名:");
        JLabel passwordLabel = new JLabel("密码:");

        // 创建文本框用于输入用户名和密码
        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);

        // 创建登录按钮，并为其设置事件监听器（这里只是打印出登录信息）
        JButton loginButton = new JButton("登录/注册");
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            System.out.println("用户名: " + username + ", 密码: " + password);
        });

        // 使用GridLayout布局管理器
        JPanel panel = new JPanel(new GridLayout(3, 2));

        // 将所有组件添加到面板上
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // 空白占位符
        panel.add(loginButton);

        // 将面板添加到窗口中
        jf.add(panel);

        // 设置窗口居中显示
        jf.setLocationRelativeTo(null);

        // 显示窗口
        jf.setVisible(true);
    }
}
