package com.bean;

import com.tool.Add;

import java.util.Scanner;

public class AddGoods implements Add {
    @Override
    public Goods add() {
        Scanner s = new Scanner(System.in);
        Goods goods = new Goods();
        System.out.print("商品名:");
        goods.setName(s.next());
        System.out.print("数量:");
        goods.setNumber(s.nextInt());
        System.out.print("价格:");
        goods.setPrice(s.nextDouble());
        return goods;
    }
}
