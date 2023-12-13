package com.tool;
import com.bean.People;

import java.io.IOException;
import java.io.File;
import java.io.*;
import java.util.ArrayList;

public class IO {
    static String[] people1 = {"商家","用户"};
    public void IPeopleFile(ArrayList<People> pp) throws IOException {
        File destPath = new File("d:\\javaShopping.txt");
        // 获取集合中的每一个Student对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(destPath));
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
    }

}
