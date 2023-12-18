package com.main;

import com.bean.*;
import com.tool.IO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static com.tool.IO.readTxt;
import static com.tool.IO.writeFile;

public class main {
    static Scanner s = new Scanner(System.in);

    static String[] people1 = {"商家","用户"};
    static String filePath = "d:\\javaShopping.txt";
    public static void main(String[] args) throws IOException {
        //登入界面
        ArrayList<People> people = new ArrayList<>();
        ArrayList<Goods> goods = new ArrayList<>();
        ArrayList<Goods> ygoods = new ArrayList<>();
        String readTxt = readTxt(filePath);
        People p1 =new LoginUI().Login();
        //选择功能
         p:while (true){
            System.out.print("输入p继续:");
            people.add(p1);
            writeFile(filePath,p1.getName() + "\t\t" + p1.getPassword() + "\t\t" + people1[p1.getType()]);
            String h = s.next();
            if (!h.equals("p")){
                System.out.println("输入错误!");
                break;
            }
            if (p1.getType() == 0){
                Menu();
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
                        //new IO().IPeopleFile(people);

                    }

                }
            }else if (p1.getType() == 1){
                Menu1();
                switch (s.nextInt()){
                    case 0 -> {
                        break p;
                    }
                    case 1 -> {
                        System.out.println("商品名称：\t数量：\t价格：\t");
                        Iterator<Goods> it = goods.iterator();
                        while (it.hasNext()){
                            Goods g = it.next();
                            System.out.println(g.getName() + "\t\t\t" + g.getNumber() + "\t\t" + g.getPrice() + "\t");
                        }
                    }
                    case 2 -> {
                        while (true){
                            Goods w = gdfind(goods);
                            Goods w1 = new Goods(w.getName(),0, w.getPrice());
                            if (w == null){
                                System.out.println("没有找到商品");
                            }else {
                                int ynum = w.getNumber();
                                System.out.println("商品名称:" + w.getName() + "\t剩余数量:" + ynum + "\t价格:" + w.getPrice());
                                System.out.print("请输入商品数量:");
                                int num = s.nextInt();
                                if (num > ynum){
                                    System.out.println("数量不够,买不了!");
                                }else {
                                    w1.setNumber(num);
                                    w.setNumber(ynum-num);
                                    ygoods.add(w1);
                                }

                            }
                        }
                    }
                    case 3 -> {
                        double hh =  new SumGoods().sum(ygoods);
                        System.out.println("总和:" + hh);
                    }
                }
            }else {
                System.out.println("用户类型无法识别!");
                break;
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
    public static void Menu(){
        System.out.println("1.商品查询\t2.全部用户名称查询\t\t3.所有商品输出\t4.用户添加\t5.商品添加\t6.用户查询\t7.删除用户\t8.删除商品\t9.更改用户信息\t10.更改商品信息\t11.用户保存");
        System.out.print("请输入选项:");
    }
    public static void Menu1(){
        System.out.println("1.商品查询\t2.选取商品\t3.结算\t4.退出");
        System.out.print("请输入选项:");
    }

}
