package com.itheima.a02myfile;

import java.io.File;

public class FileDemo5 {
    public static void main(String[] args) {
        // 细节1：删除不走回收站
        // 细节2：删除文件夹
        //       有内容：失败
        //       空文件夹：成功
        File f1 = new File("\\d");
        boolean b = f1.delete();
        System.out.println(b);
    }
}
