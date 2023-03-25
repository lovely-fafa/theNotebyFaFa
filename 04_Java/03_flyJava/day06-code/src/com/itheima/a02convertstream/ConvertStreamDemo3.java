package com.itheima.a02convertstream;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo3 {
    public static void main(String[] args) throws IOException {
        // JDK11Before();

        // 现在的新的处理方法
        FileReader fr = new FileReader("day06-code\\gbkFile.txt", Charset.forName("GBK"));
        FileWriter fw = new FileWriter("day06-code\\gbkFileToUtf.txt", Charset.forName("UTF-8"));

        int b;
        while ((b = fr.read()) != -1) {
            fw.write(b);
        }

        fw.close();
        fr.close();

    }

    /**
     * JDK11 的方法 了解即可
     * @throws IOException
     */
    private static void JDK11Before() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("day06-code\\gbkFile.txt"), "GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("day06-code\\gbkFileToUtf.txt"));

        int b;
        while ((b = isr.read()) != -1) {
            osw.write(b);
        }

        osw.close();
        isr.close();
    }
}
