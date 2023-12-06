package com.test;

 import javax.swing.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
        public class TanChu extends JFrame {
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


        }