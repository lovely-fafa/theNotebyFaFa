package com.itheima.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CodeUtil {

    public static String getCode(){
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            list.add(String.valueOf((char)('a' + i)));
            list.add(String.valueOf((char)('A' + i)));
        }

        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            result.add(list.get(r.nextInt(list.size())));
        }
        result.add(String.valueOf(r.nextInt(10)));

        Collections.shuffle(result);
        return String.join("", result);
    }
}