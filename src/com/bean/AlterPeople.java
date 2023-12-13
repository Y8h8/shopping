package com.bean;

import com.tool.Alter;

import java.util.Scanner;

public class AlterPeople implements Alter {

    static String[] people1 = {"商家","用户"};

    @Override
    public void alter(Object object) {
        People people = (People) object;
        Scanner s = new Scanner(System.in);
        //System.out.println(people1[0]);
        k:while (true){
        System.out.println("请输入要更改的信息:1.名称\t2.密码\t3.权限\t0.退出");
        int w = s.nextInt();
        switch (w){
            case 0 -> {
                System.out.println("更改成功!");
                break k;
            }
            case 1 -> {
                System.out.print("请输入要更改的内容:" + people.getName() + "->");
                people.setName(s.next());
            }
            case 2 -> {
                System.out.print("请输入要更改的内容:" + people.getPassword() + "->");
                people.setPassword(s.next());
            }
            case 3 -> {
                System.out.print("请输入要更改的内容:" + people1[people.getType()] + "->");
                String k = s.next();
                if (k.equals(people1[0])){
                    people.setType(0);
                }else if (k.equals(people1[1])){
                    people.setType(1);
                }else {
                    System.out.println("输入错误,请重新选择!");
                }

            }

        }

        }
    }
}
