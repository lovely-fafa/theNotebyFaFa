package com.itheima.a02test;

import java.io.File;
import java.util.HashMap;

public class Test5 {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = countFileInfo(new File("D:\\大学牲\\大三上"));
        System.out.println(hm);
    }

    public static HashMap<String, Integer> countFileInfo(File src) {
        HashMap<String, Integer> hm = new HashMap<>();

        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String type = fileName;
                    if (fileName.contains(".")) {
                        String[] fileNameSplit = fileName.split("\\.");
                        type = fileNameSplit[fileNameSplit.length - 1];
                    }

                    if (hm.containsKey(type)) {
                        hm.put(type, hm.get(type) + 1);
                    } else {
                        hm.put(type, 1);
                    }
                } else {
                    HashMap<String, Integer> sonMap = countFileInfo(file);
                    for (String k : sonMap.keySet()) {
                        if (hm.containsKey(k)) {
                            hm.put(k, hm.get(k) + sonMap.get(k));
                        } else {
                            hm.put(k, sonMap.get(k));
                        }
                    }
                }
            }
        }
        return hm;
    }
}
