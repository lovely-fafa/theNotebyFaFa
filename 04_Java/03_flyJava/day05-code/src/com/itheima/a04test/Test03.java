package com.itheima.a04test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test03 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("day05-code\\aaa\\a0.txt");

        StringBuilder sb = new StringBuilder();  // 2-1-9-4-7-8
        int ch;
        while ((ch = fr.read()) != -1) {
            sb.append((char) ch);
        }

        String string = sb.toString();

        // 方法一
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (String s : string.split("-")) {
            arr1.add(Integer.parseInt(s));
        }
        Collections.sort(arr1);

        FileWriter fw = new FileWriter("day05-code\\aaa\\a0.txt");
        for (int i = 0; i < arr1.size(); i++) {
            if (i == arr1.size() - 1) {
                fw.write(arr1.get(i) + "");
            } else {
                fw.write(arr1.get(i) + "-");
            }
        }

        // 方法二
        Integer[] arr2 = Arrays.stream(string.split("-"))
                .map(Integer::parseInt)
                .sorted().toArray(Integer[]::new);
        // Arrays.toString(arr2) -> String 形式的 [1, 2, 3, 4]
        String s = Arrays.toString(arr2).replace(", ", "-");
        String result = s.substring(1, s.length() - 1);

        fw.close();
        fr.close();
    }
}
