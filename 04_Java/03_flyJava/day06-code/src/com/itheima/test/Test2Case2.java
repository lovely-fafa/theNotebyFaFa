package com.itheima.test;

import java.io.*;
import java.util.*;

public class Test2Case2 {
    public static void main(String[] args) throws IOException {
        /*
            出师表排序
         */
        BufferedReader br = new BufferedReader(new FileReader("day06-code\\src\\com\\itheima\\test\\csb.txt"));

        TreeMap<Integer, String> tm = new TreeMap<>();
        String line;
        while ((line = br.readLine()) != null) {
            // 介个 2 是指分出来两个东西 即分一次...
            String[] temp = line.split("\\.", 2);
            tm.put(Integer.parseInt(temp[0]), temp[1]);
        }

        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("day06-code\\src\\com\\itheima\\test\\csb_rse2.txt"));
        for (Map.Entry<Integer, String> entry : tm.entrySet()) {
            bw.write(entry.getKey() + "." + entry.getValue());
            bw.newLine();
        }
        bw.close();
    }
}
