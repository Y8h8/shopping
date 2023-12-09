package com.bean;

import com.tool.Find;

import java.util.ArrayList;

public class FindPeople implements Find {
    @Override
    public People find(String s, ArrayList objectArrayList) {
        for (Object obj : objectArrayList){
            People w = (People) obj;
            if (s.equals(w.getName())){
                return w;
            }
        }
        return null;
    }
}
