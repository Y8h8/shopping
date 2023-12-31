package com.bean;

public class Goods {
    private String name;
    private int number;
    private double price;

    public Goods(String name, int number, double price) {
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
