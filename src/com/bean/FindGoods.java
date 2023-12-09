package com.bean;

import com.tool.Find;

import java.util.ArrayList;
import java.util.Objects;

public class FindGoods implements Find {
    @Override
    public Goods find(String s, ArrayList objectArrayList) {

        for (Object obj : objectArrayList){
            Goods w = (Goods) obj;
            if (s.equals(w.getName())){
                return w;
            }
        }
        return null;
    }
}
