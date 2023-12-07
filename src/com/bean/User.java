package com.bean;

import com.tool.Add;

public class User extends People implements Add {
    public User() {
    }

    public User(String name, String password, double money) {
        super(name, password, money);
    }


    @Override
    public void add() {
        
    }
}
