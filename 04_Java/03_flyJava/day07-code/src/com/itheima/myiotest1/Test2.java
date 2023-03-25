package com.itheima.myiotest1;

import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        String url = "http://www.haoming8.cn/baobao/7641.html";

        String resp = HttpUtil.get(url);
        List<String> data = ReUtil.findAll("<p>((.. ){4}..)</p>", resp, 1);
        System.out.println(data);

    }
}
