package com.itheima.a02mybytestream2;

public class ByteStreamDemo7 {
    // JDK7：IO 流中捕获异常的写法
    public static void main(String[] args) {
        // 注意：只有实现了 Autocloseable 接口的类，才能在小括号中创建对象。
//        try(FileInputStream fls = new FileInputStream("D:\\百度网盘\\学习OpenCV 3 中文版.zip");
//            FileOutputStream fos = new FileOutputStream("D:\\百度网盘\\学习OpenCV 3 中文版2.zip")) {
//
//            int len;
//            byte[] bytes = new byte[1024 * 1024 * 5];
//            while ((len = fls.read(bytes)) != -1) {
//                fos.write(bytes, 0, len);
//            }
//
//        } catch (IIOException e) {
//            e.printStackTrace();
//        }
    }
}
