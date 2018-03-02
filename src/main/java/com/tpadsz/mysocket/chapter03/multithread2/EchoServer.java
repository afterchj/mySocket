package com.tpadsz.mysocket.chapter03.multithread2;

import com.tpadsz.mysocket.utils.Handler;
import java.io.*;
import java.net.*;

public class EchoServer {
    private int port = 8000;
    private ServerSocket serverSocket;
    private ThreadPool threadPool;  //线程池
    private final int POOL_SIZE = 4;  //单个CPU时线程池中工作线程的数目

    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);
        //创建线程池
        //Runtime的availableProcessors()方法返回当前系统的CPU的数目
        int cpu_num = Runtime.getRuntime().availableProcessors();
        System.out.println("系统的CPU的数目：" + cpu_num);
        //系统的CPU越多，线程池中工作线程的数目也越多
        threadPool = new ThreadPool(cpu_num * POOL_SIZE);

        System.out.println("服务器启动...");
    }

    public void service() {
        while (true) {
            Socket socket=null;
            try {
                socket = serverSocket.accept();
                threadPool.execute(new Handler(socket)); //把与客户通信的任务交给线程池
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws IOException {
        new EchoServer().service();
    }
}
