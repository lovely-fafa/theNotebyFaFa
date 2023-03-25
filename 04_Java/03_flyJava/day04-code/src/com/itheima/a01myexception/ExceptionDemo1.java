package com.itheima.a01myexception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo1 {
    public static void main(String[] args) throws ParseException {
        // 编译时异常（编译阶段，需要手动处理，否则代码报错）
        String time = "2023年1月1日";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年mm月dd日");
        Date date = sdf.parse(time);
        System.out.println(date);

        // 运行时异常（编译阶段不需要处理，代码运行时出现的异常）
        int[] arr = {1, 2, 3};
        System.out.println(arr[10]);  // ArrayIndexOutOfBoundsException
    }
}
