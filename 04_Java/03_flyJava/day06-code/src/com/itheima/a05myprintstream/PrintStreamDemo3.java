package com.itheima.a05myprintstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

public class PrintStreamDemo3 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("day06-code\\f.txt"), true);
        pw.println("喜欢你捏");
        pw.print("您好");
        pw.printf("%s爱上了%s", "阿珍", "阿强");
        pw.close();
    }
}
