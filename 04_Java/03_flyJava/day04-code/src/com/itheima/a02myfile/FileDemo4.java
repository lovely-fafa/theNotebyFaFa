package com.itheima.a02myfile;

import java.io.File;
import java.io.IOException;

public class FileDemo4 {
    public static void main(String[] args) throws IOException {
        // 1. 创建文件
        // 细节1：文件不存在，创建成功，返回 true
        //       文件存在，创建失败，返回 false
        // 细节2：父级路径不存在 IOException
        // 细节3：创建的一定是文件 没有后缀名 也会创建一个没有后缀名的文件
        File f1 = new File("\\b.mp3");
        boolean b = f1.createNewFile();
        System.out.println(b);  // 是否成功

        // 2. 创建文件夹
        // 细节1：Windows 路径必须唯一（所以一个没有后缀名的文件路径和文件夹路径会冲突...）
        // 细节2：只能创建单击文件夹 不能创建多级文件夹
        File f2 = new File("\\d");
        boolean bb = f2.mkdir();
        System.out.println(bb);  // 是否成功

        // 3. 创建多级文件夹
        File f3 = new File("\\d\\dd\\ccc");
        boolean bbb = f3.mkdirs();
        System.out.println(bbb);
    }
}
