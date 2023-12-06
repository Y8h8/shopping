package com.main;

import com.bean.Goods;
import com.test.TanChu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //选择商品
        Scanner s = new Scanner(System.in);
        ArrayList<Goods> goods = new ArrayList<>();
        while (true){

            switch (s.nextInt()){
                case 1 ->  SwingUtilities.invokeLater(Menu::createAndShowGUI);
                case 2 -> {
                    System.out.println("添加");
                    Goods k =new Goods();
                    System.out.print("姓名：");
                    k.setName(s.next());
                    System.out.print("数量：");
                    k.setNumber(s.nextInt());
                    System.out.print("价格：");
                    k.setPrice(s.nextDouble());
                    goods.add(k);
                }
                case 3 -> {
                    System.out.println("姓名：\t数量：\t价格：\t");
                    Iterator<Goods> it = goods.iterator();
                    while (it.hasNext()){
                        Goods g = it.next();
                        System.out.println(g.getName()+g.getNumber()+g.getPrice());
                    }
                }
            }
        }
    }

}
