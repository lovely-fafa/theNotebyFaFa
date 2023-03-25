package com.itheima.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) throws IOException {
        /*
            出师表排序
         */
        BufferedReader br = new BufferedReader(new FileReader("day06-code\\src\\com\\itheima\\test\\csb.txt"));

        ArrayList<String> arr = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            arr.add(line);
        }

        br.close();

        // 排序
        String[] result = arr.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int value1 = Integer.parseInt(o1.split("\\.")[0]);
                int value2 = Integer.parseInt(o2.split("\\.")[0]);

                return value1 - value2;
            }
        }).toArray(String[]::new);

        BufferedWriter bw = new BufferedWriter(new FileWriter("day06-code\\src\\com\\itheima\\test\\csb_rse.txt"));
        for (String s : result) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }
}
