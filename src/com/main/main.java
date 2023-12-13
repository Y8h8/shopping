package com.main;

import com.bean.*;
import com.tool.IO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class main {
    static Scanner s = new Scanner(System.in);

    static String[] people1 = {"商家","用户"};
    public static void main(String[] args) throws IOException {
        //登入界面
        ArrayList<People> people = new ArrayList<>();
        ArrayList<Goods> goods = new ArrayList<>();

        people.add(new LoginUI().Login());


        //选择功能
        while (true){

            switch (s.nextInt()){
                //商品查询
                case 1 -> {
                    Goods w = gdfind(goods);
                    if (w == null){
                        System.out.println("没有找到商品");
                    }else {
                        System.out.println("商品名称:" + w.getName() + "\t数量:" + w.getNumber() + "\t价格:" + w.getPrice());
                    }
                }
                //全部用户名称查询
                case 2 -> {
                    Iterator<People> it = people.iterator();
                    while (it.hasNext()){
                        People p = it.next();
                        System.out.println("用户名称:" + p.getName() + "\t年龄:" + p.getPassword() + "\t类型:" + people1[p.getType()]);
                    }
                }
                //所有商品输出
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
                //用户查询
                case 6 -> {
                    People w = ppfind(people);
                    if (w == null){
                        System.out.println("没有用户");
                    }else {
                        System.out.println("用户名称:" + w.getName() + "\t年龄:" + w.getPassword() + "\t类型:" + people1[w.getType()]);
                    }
                }
                //删除用户
                case 7 -> {
                    People w = ppfind(people);
                    if (w == null){
                        System.out.println("没有该用户");
                    }else {
                        new DelPeople().del(w,people);
                        System.out.println("删除成功!");
                    }
                }
                //删除商品
                case 8 -> {
                    Goods w = gdfind(goods);
                    if (w == null){
                        System.out.println("没有商品");
                    }else {
                        new DelGoods().del(w,goods);
                        System.out.println("删除成功!");
                    }
                }
                //更改用户信息
                case 9 -> {
                    new AlterPeople().alter(ppfind(people));
                }
                //更改商品信息
                case 10 -> {
                    new AlterGoods().alter(gdfind(goods));
                }
                //用户保存
                case 11 -> {
                        new IO().IPeopleFile(people);

                }

            }
        }
    }
    public static People ppfind(ArrayList people){
        System.out.print("用户名名称:");
        String k = s.next();
        People w = new FindPeople().find(k,people);
        return w;

    }
    public static Goods gdfind(ArrayList goods){
        System.out.print("商品名称:");
        String k = s.next();
        Goods w = new FindGoods().find(k,goods);
        return w;
    }

}
