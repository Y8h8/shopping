package com.bean;

public class People {
    private String name;
    private String password;
    private double money;
    private int type;
    public People() {
    }

    public People(String name, String password, double money, int type) {
        this.name = name;
        this.password = password;
        this.money = money;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
