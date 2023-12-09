package com.bean;

import com.tool.Del;

import java.util.ArrayList;

public class DelGoods implements Del {

    @Override
    public void del(Object object, ArrayList arrayList) {
        arrayList.remove(object);
    }
}
