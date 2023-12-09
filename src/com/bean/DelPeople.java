package com.bean;

import com.tool.Del;

import java.util.ArrayList;
import java.util.Objects;

public class DelPeople implements Del {
    @Override
    public void del(Object object, ArrayList arrayList) {
        arrayList.remove(object);
    }
}
