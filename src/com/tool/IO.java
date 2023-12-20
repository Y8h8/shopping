package com.tool;
import com.bean.Goods;
import com.bean.People;

import java.io.IOException;
import java.io.File;
import java.io.*;
import java.util.ArrayList;


public class IO {
    static String[] people1 = {"商家","用户"};
    public void IPeopleFile(ArrayList<People> pp) throws IOException {
        File f = new File("d:\\javaShoppingUser.txt");

        if (f.exists()) {
            System.out.print("文件存在");
        } else {
            System.out.print("文件不存在,正在创建...");
            f.createNewFile();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));

        bw.flush();

        for (People s : pp) {
            String name = s.getName();
            String password = s.getPassword();
            String type = people1[s.getType()];

            bw.write(name + ",");
            bw.write(password + ",");
            bw.write(type);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        System.out.println("存储成功!");
    }

    public String OPeopleFile(String file1) {
                StringBuilder lineTxt = new StringBuilder();
                try {
                    File file = new File(file1);
                    if(file.isFile() && file.exists()) {
                        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
                        BufferedReader br = new BufferedReader(isr);
                        String lineTxt1;
                        while ((lineTxt1 = br.readLine()) != null) {
                            lineTxt.append(lineTxt1).append("\n");
                        }

                        br.close();

                    } else {
                        //System.out.println("文件不存在!");
                    }
                } catch (Exception e) {
                    System.out.println("文件读取错误!");
                }
                return lineTxt.toString();
    }

    public String OGoodsFile(String file1){
        StringBuilder lineTxt = new StringBuilder();
        try {
            File file = new File(file1);
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
                BufferedReader br = new BufferedReader(isr);
                String lineTxt1;
                while ((lineTxt1 = br.readLine()) != null) {
                    lineTxt.append(lineTxt1).append("\n");
                }

                br.close();

            } else {
                //System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }
        return lineTxt.toString();
    }
    public void IGoodsFile(ArrayList<Goods> goodsArrayList) throws IOException {
        File f = new File("d:\\javaShoppingGoods.txt");
        if (f.exists()) {
            System.out.print("文件存在");
        } else {
            System.out.print("文件不存在,正在创建...");
            f.createNewFile();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));

        for (Goods s : goodsArrayList) {
            String name = s.getName();
            double price = s.getPrice();
            int number = s.getNumber();

            bw.write(name + ",");
            bw.write(price + ",");
            bw.write(number + "\n");
            bw.flush();
        }

        bw.close();
        System.out.println("存储成功!");
    }

}