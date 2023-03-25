package com.itheima.a02myfile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo3 {
    public static void main(String[] args) {
        File f1 = new File("D:\\aaa\\a.txt");

        // 1. 文件大小
        // 细节一：只能获得文件的大小 单位 kb
        // 细节二：不能获得文件夹的大小
        long len = f1.length();
        System.out.println(len);

        // 2. 绝对路径
        File f2 = new File("a.txt");
        System.out.println(f2.getAbsoluteFile());

        // 3. 定义文件对象的路径
        System.out.println(f2.getPath());

        // 4. 获取文件名字
        // 细节一：调用者是文件：返回文件名+后缀名
        //       调用者是文件夹：返回文件夹名字
        System.out.println(f2.getName());

        // 5. 文件最后的修改时间（时间毫秒值）
        long time = f2.lastModified();

        Date date = new Date();
        date.setTime(time);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeFormat = sdf.format(date);
        System.out.println(timeFormat);
    }
}
