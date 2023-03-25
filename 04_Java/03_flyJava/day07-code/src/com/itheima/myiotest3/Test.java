package com.itheima.myiotest3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    // 登录小案例
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("day07-code\\src\\com\\itheima\\myiotest3\\userinfo.txt"));
        String line = br.readLine();
        br.close();

        String[] userInfo = line.split("&");
        String rightUsername = userInfo[0].split("=")[1];
        String rightPassword = userInfo[1].split("=")[1];

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        if (rightUsername.equals(username)) {
            if (rightPassword.equals(password)) {
                System.out.println("登陆成功");
            } else {
                System.out.println("密码错误");
            }
        } else {
            System.out.println("用户不存在");
        }
    }
}
