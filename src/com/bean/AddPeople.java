package com.bean;

import com.tool.Add;

import java.util.Scanner;

public class AddPeople implements Add {
    @Override
     public People add() {
        People people = null;
        Scanner s = new Scanner(System.in);
        System.out.println("1.商家注册\n2.user注册\n");
        int x = s.nextInt();
        switch (x){
            case 1 -> {
                people = new Root();
                System.out.print("名字:");
                people.setName(s.next());
                System.out.print("密码:");
                people.setPassword(s.next());
                people.setType(0);
                people.setMoney(0.0);
            }
            case 2 -> {
                people = new User();
                System.out.print("名字:");
                people.setName(s.next());
                System.out.print("\n密码:");
                people.setPassword(s.next());
                people.setType(1);
                people.setMoney(0.0);
            }
        }
        return people;


    }
}
