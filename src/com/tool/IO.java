package com.tool;
/*import com.bean.People;

import java.io.IOException;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class IO {
    static String[] people1 = {"商家","用户"};
    public void IPeopleFile(ArrayList<People> pp) throws IOException {
        File f = new File("d:\\javaShopping.txt");

        if (f.exists()) {
            System.out.print("文件存在");
        } else {
            System.out.print("文件不存在,正在创建...");
            f.createNewFile();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
        bw.newLine();
        bw.flush();

        for (People s : pp) {
            String name = s.getName();
            String password = s.getPassword();
            String type = people1[s.getType()];

            bw.write(name + "\t\t");
            bw.write(password + "\t\t");
            bw.write(type + "\t\t");
            bw.newLine();
            bw.flush();
        }
        bw.close();
        System.out.println("存储成功!");
    }

    public void OPeopleFile(File file) {


    }
}*/
import java.io.*;
import java.nio.charset.StandardCharsets;

public class IO{

        public static String readTxt(String filePath) {
            StringBuilder lineTxt = new StringBuilder();
            try {
                File file = new File(filePath);
                if(file.isFile() && file.exists()) {
                    InputStreamReader isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                    BufferedReader br = new BufferedReader(isr);
                    String lineTxt1;
                    while ((lineTxt1 = br.readLine()) != null) {
                        lineTxt.append(lineTxt1).append("\n");
                    }

                    br.close();

                } else {
                    System.out.println("文件不存在!");
                }
            } catch (Exception e) {
                System.out.println("文件读取错误!");
            }
            return lineTxt.toString();
        }
        public static void writeFile(String filePath, String content) throws IOException {
            //true表示追加内容
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            bufferedWriter.write(content);
            //换行
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println("保存成功");
        }
}
