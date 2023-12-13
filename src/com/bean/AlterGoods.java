package com.bean;

import com.tool.Alter;

import java.util.Scanner;

public class AlterGoods implements Alter {
    Scanner s = new Scanner(System.in);
    @Override
    public void alter(Object object) {
        Goods g = (Goods)object;
        p:while (true){
            System.out.print("请选择更改商品的内容\t0.退出\t1.名称\t2.数量\t3.价格:");
            int chioce = s.nextInt();
            switch (chioce){
                case 0 -> {
                    break p;
                }
                case 1 -> {
                    g.setName(s.next());
                }
                case 2 -> {
                    g.setNumber(s.nextInt());
                }
                case 3 -> {
                    g.setPrice(s.nextDouble());
                }
            }
        }
    }
}
