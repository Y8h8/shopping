package com.main;

import com.bean.*;
import com.tool.IO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class main {
    static Scanner s = new Scanner(System.in);

    static String[] people1 = {"商家","用户"};
    static String filePath = "d:\\javaShoppingUser.txt";
    static String filePath1 = "d:\\javaShoppingGoods.txt";
    public static void main(String[] args) throws IOException {
        //登入界面
        ArrayList<People> people = new ArrayList<>();
        ArrayList<Goods> goods = new ArrayList<>();
        ArrayList<Goods> ygoods = new ArrayList<>();


        //读取用户
        File filepp = new File(filePath);
        People p1;
        IO ioo = new IO();
        if (filepp.isFile() && filepp.exists()) {
            String string = ioo.OPeopleFile(filePath);
            String[] hh1 = string.split("\n");
            for (String string1 : hh1) {
                String[] ee = string1.split(",");
                p1 = new People();
                p1.setName(ee[0]);
                p1.setPassword(ee[1]);
                if (ee[2].equals(people1[0])) {
                    p1.setType(0);
                } else if (ee[2].equals(people1[1])) {
                    p1.setType(1);
                }
                people.add(p1);
            }
        }


        //读取商品
        IO goo = new IO();
        String string2 = goo.OGoodsFile(filePath1);
        String[] gg1 = string2.split("\n");
        for (String stringg : gg1) {
            String[] gg = stringg.split(",");
            if (gg.length == 3) {
                double priceg = Double.parseDouble(gg[1]);
                int numberg = Integer.valueOf(gg[2]).intValue();
                Goods goods2 = new Goods(gg[0], numberg, priceg);
                goods.add(goods2);
            }
        }

        //判断登入密码
        hh:while (true) {
            p1 = new LoginUI().Login();
            System.out.print("输入0登入：");
            boolean hhh = false;

            if (s.nextInt() == 0) {
                for (People ppp : people) {
                    if ((p1.getName().equals(ppp.getName())) && (p1.getType() == ppp.getType())) {
                        hhh = true;
                        if (p1.getPassword().equals(ppp.getPassword())) {
                            break hh;
                        } else {
                            System.out.println("密码错误!");
                        }

                    }
                }

                if (!hhh) {
                    //如果没找到添加到用户集合中
                    people.add(p1);
                    break;
                }
            }
            //暂停
            System.out.print("输入任意键继续：");
            pressAnykeyToContinue();
            pressAnykeyToContinue();
        }


        //选择功能
         p:while (true){

            if (p1.getType() == 0){
                //保存用户名
                new IO().IPeopleFile(people);

                //商家功能
                System.out.println();
                Menu();
                switch (s.nextInt()){
                    //退出
                    case 0 -> {
                        break p;
                    }
                    //商品查询
                    case 1 -> {
                        Goods w = gdfind(goods);
                        if (w == null){
                            System.out.println("没有找到商品");
                        }else {
                            System.out.println("商品名称:" + w.getName() + "\t数量:" + w.getNumber() + "\t价格:" + w.getPrice());
                        }
                    }

                    //商品添加
                    case 2 -> {
                        goods.add(new AddGoods().add());
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
                    //删除商品
                    case 4 -> {
                        Goods w = gdfind(goods);
                        if (w == null){
                            System.out.println("没有商品");
                        }else {
                            new DelGoods().del(w,goods);
                            System.out.println("删除成功!");
                        }
                    }

                    //用户查询
                    case 5 -> {
                        People w = ppfind(people);
                        if (w == null){
                            System.out.println("没有用户");
                        }else {
                            System.out.println("用户名称:" + w.getName() + "\t密码:" + w.getPassword() + "\t类型:" + people1[w.getType()]);
                        }
                    }
                    //全部用户名称查询
                    case 6 -> {
                        Iterator<People> it = people.iterator();
                        while (it.hasNext()){
                            People p = it.next();
                            System.out.println("用户名称:" + p.getName() + "\t密码:" + p.getPassword() + "\t类型:" + people1[p.getType()]);
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
                    //用户添加
                    case 8 -> {
                        people.add(new AddPeople().add());
                    }
                    //更改用户信息
                    case 9 -> {
                        new AlterPeople().alter(ppfind(people));
                    }
                    //更改商品信息
                    case 10 -> {
                        new AlterGoods().alter(gdfind(goods));
                    }
                    //保存
                    case 11 -> {
                        new IO().IPeopleFile(people);
                        new IO().IGoodsFile(goods);
                    }

                }
                System.out.println("请输入任意键继续：");
                pressAnykeyToContinue();
                pressAnykeyToContinue();

            }else if (p1.getType() == 1){
                //保存用户名
                new IO().IPeopleFile(people);

                //用户
                System.out.println();
                Menu1();
                switch (s.nextInt()){
                    case 0 -> {
                        //退出程序
                        break p;
                    }
                    case 1 -> {
                        //显示商品
                        System.out.println("商品名称:\t\t数量:\t\t价格:");
                        Iterator<Goods> it = goods.iterator();
                        while (it.hasNext()){
                            Goods g = it.next();
                            System.out.println(g.getName() + " \t\t\t" + g.getNumber() + " \t\t\t" + g.getPrice() );
                        }
                    }
                    case 2 -> {
                        //选择商品
                        while (true){
                            Goods w = gdfind(goods);
                            if (w == null){
                                System.out.println("没有找到商品");
                            }else {
                                Goods w1 = new Goods(w.getName(),0, w.getPrice());
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

                            System.out.println("输入0返回,输入1继续:");
                            int vvv = s.nextInt();
                            if (vvv == 0){
                                break ;
                            }else if (vvv == 1){
                            }
                        }
                    }
                    case 3 -> {
                        //结账
                        double hh =  new SumGoods().sum(ygoods);
                        System.out.println("总和:" + String.format("%.2f",hh));
                        System.out.println("1.微信支付\n2.支付宝支付\n3.其他支付");
                        switch (s.nextInt()){
                            case 1 -> {
                                System.out.println("微信已付款");
                            }
                            case 2 -> {
                                System.out.println("支付宝已付款");
                            }
                            case 3 -> {
                                System.out.println("其他方式已付款");
                            }
                        }
                        new IO().IGoodsFile(goods);

                    }
                }
                System.out.println("请输入任意键继续：");
                pressAnykeyToContinue();
                pressAnykeyToContinue();
            }else {
                System.out.println("用户类型无法识别!");
                break;
            }
        }
    }

    public static People ppfind(ArrayList people) {
        System.out.print("用户名名称:");
        String k = s.next();
        People w = new FindPeople().find(k,people);
        return w;

    }

    public static Goods gdfind(ArrayList goods) {
        System.out.print("商品名称:");
        String k = s.next();
        Goods w = new FindGoods().find(k,goods);
        return w;
    }

    public static void Menu(){
        System.out.println("0.退出\t\t\t\t1.商品查询\n2.商品添加\t\t\t3.所有商品输出\n4.删除商品\t\t\t5.用户查询\n6.全部用户名称查询\t\t7.删除用户\n8.用户添加\t\t\t9.更改用户信息\n10.更改商品信息\t\t11.保存");
        System.out.print("请输入选项:");
    }

    public static void Menu1(){
        System.out.println("1.商品查询\t2.选取商品\t3.结算\t0.退出");
        System.out.print("请输入选项:");
    }

    public static void pressAnykeyToContinue() {
        s.nextLine();
    }

}
