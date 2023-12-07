package com.bean;

import com.tool.Add;

import java.util.Scanner;

public class AddPeople implements Add {
    @Override
    public void add() {
        Scanner s = new Scanner(System.in);
        System.out.println("1.root注册\n2.user注册\n");
        int x = s.nextInt();
        switch (x){
            case 1 -> {
                People people = new Root();
                System.out.print("名字:");
                people.setName(s.next());
                System.out.print("密码:");
                people.setPassword(s.next());
                System.out.print("资金:");
                people.setMoney(s.nextDouble());
                System.out.println();
            }
            case 2 -> {
                People people = new User();
                System.out.print("名字:");
                people.setName(s.next());
                System.out.print("\n密码:");
                people.setPassword(s.next());
                //System.out.print("\n资金:");
                //people.setMoney(s.nextDouble());
                System.out.println();
            }
        }


    }
}
