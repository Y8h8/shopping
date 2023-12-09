package com.main;

import com.bean.AddGoods;
import com.bean.AddPeople;
import com.bean.Goods;
import com.bean.People;
import com.test.TanChu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //登入界面
        new LoginUI().Login();
        //选择功能
        Scanner s = new Scanner(System.in);
        ArrayList<People> people = new ArrayList<>();
        ArrayList<Goods> goods = new ArrayList<>();
        while (true){

            switch (s.nextInt()){
                case 1 -> {}
                //用户名称
                case 2 -> {

                }
                //商品输出
                case 3 -> {
                    System.out.println("商品名称：\t数量：\t价格：\t");
                    Iterator<Goods> it = goods.iterator();
                    while (it.hasNext()){
                        Goods g = it.next();
                        System.out.println(g.getName() + "\t\t\t" + g.getNumber() + "\t\t" + g.getPrice() + "\t");
                    }
                }
                //用户添加
                case 4 -> {
                    people.add(new AddPeople().add());
                }
                //商品添加
                case 5 -> {
                    goods.add(new AddGoods().add());
                }

            }
        }
    }

}
