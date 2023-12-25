package com.tool;
import com.bean.Goods;
import com.bean.People;

import java.io.IOException;
import java.io.File;
import java.io.*;
import java.util.ArrayList;


public class IO {
    StringBuilder lineTxt = new StringBuilder();
    static String[] people1 = {"商家","用户"};
    public void IPeopleFile(ArrayList<People> pp) throws IOException {
        File f = new File("d:\\javaShoppingUser.txt");
        if(!f.exists()) {
            //没有文件
            f.createNewFile();
        }
        FileWriter writer = new FileWriter(f);
        BufferedWriter out = new BufferedWriter(writer);
        for (People people : pp){
            out.write(people.getName() + "," + people.getPassword() + "," +people1[people.getType()]+ "\n");
        }
        out.flush();
        out.close();
    }

    public String OPeopleFile(String file1) {
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
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }
        return lineTxt.toString();
    }

    public String OGoodsFile(String file1){

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

            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }
        return lineTxt.toString();
    }
    public void IGoodsFile(ArrayList<Goods> goodsArrayList) throws IOException {

        File writeName = new File("d:\\javaShoppingGoods.txt");
        if(!writeName.exists()) {
            //没有文件
            writeName.createNewFile();
        }
        FileWriter writer = new FileWriter(writeName);
        BufferedWriter out = new BufferedWriter(writer);
        for (Goods goods : goodsArrayList){
            out.write(goods.getName() + "," + goods.getPrice() + "," +goods.getNumber() + "\n");
        }
        out.flush();
        out.close();
    }



}