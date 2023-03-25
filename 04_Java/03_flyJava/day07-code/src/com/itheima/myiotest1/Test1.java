package com.itheima.myiotest1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) throws IOException {
        String url = "http://www.haoming8.cn/baobao/7641.html";
        String s = webCrawler(url);

        ArrayList<String> girlNameList = getData(s);
        HashSet<String> info = getInfo(girlNameList, 100);

        BufferedWriter bw = new BufferedWriter(new FileWriter("day07-code\\src\\com\\itheima\\myiotest1\\name.txt"));
        for (String str : info) {
            bw.write(str);
            bw.newLine();
        }
        bw.close();
    }

    public static HashSet<String> getInfo(ArrayList<String> girlNameList, int count) {
        HashSet<String> hs = new HashSet<>();
        Random r = new Random();
        while (true) {
            if (hs.size() == count) {
                break;
            } else {
                String name = girlNameList.get(r.nextInt(girlNameList.size()));
                String gender = r.nextInt(2) == 1 ? "男" : "女";
                int age = r.nextInt(18, 28);
                hs.add(name + "-" + gender + "-" + age + "-1");
            }
        }
        return hs;
    }

    private static ArrayList<String> getData(String s) {
        ArrayList<String> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("<p>(.. .. .. .. ..)</p>");
        // <p>雅琳 雪瑶 从璐 芳卉 雅琴</p>
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String group = matcher.group(1);
            Collections.addAll(list, group.split(" "));
        }
        return list;
    }

    public static String webCrawler(String net) throws IOException {
        StringBuilder sb = new StringBuilder();
        // 创建 URL 对象
        URL url = new URL(net);
        // 链接上整个网址
        URLConnection conn = url.openConnection();
        // 获取数据
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());

        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        isr.close();

        return sb.toString();
    }
}
