package com.bean;

import java.util.ArrayList;
import java.util.Iterator;

public class SumGoods {
    public double sum(ArrayList<Goods> goods){
        double su = 0;
        System.out.println("商品名字:\t数量\t\t价格");
        Iterator<Goods> it = goods.iterator();
        while (it.hasNext()){
            Goods g = it.next();
            System.out.println(g.getName() + "\t\t\t" + g.getNumber() + "\t\t" + g.getPrice());
            System.out.println(g.getPrice());
            double k = g.getNumber() * g.getPrice();
            su = su + k;
            //System.out.println(k);
        }
        return su;
    }
}
