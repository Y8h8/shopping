package com.bean;

import com.tool.Add;

public class User extends People {
    public User() {
    }

    public User(String name, String password, double money, int type) {
        super(name, password, money, type);
    }
}
