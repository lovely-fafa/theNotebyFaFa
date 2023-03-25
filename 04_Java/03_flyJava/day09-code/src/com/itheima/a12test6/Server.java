package com.itheima.a12test6;

import com.itheima.a11test5.MyRunnable;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) throws IOException {
        // 客户端:将本地文件上传到服务器。接收服务器的反馈。
        // 服务器:接收客户端上传的文件，上传完毕之后给出反馈。

        // 创建线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,
                16,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        ServerSocket ss = new ServerSocket(10000);

        while (true) {
            Socket socket = ss.accept();

            pool.submit(new MyRunnable(socket));
        }

    }
}
