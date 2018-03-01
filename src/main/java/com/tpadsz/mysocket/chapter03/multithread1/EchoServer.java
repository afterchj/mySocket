package com.tpadsz.mysocket.chapter03.multithread1;

import com.tpadsz.mysocket.utils.Service;

import java.io.*;
import java.net.*;

public class EchoServer {
    private int port = 8000;
    private ServerSocket serverSocket;


    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动...");
    }

    public void service() throws IOException {
        for (int i=0;i<20;i++) {
            Socket socket = serverSocket.accept();  //接收客户连
            Thread workThread = new Thread(()->{
                new Service().run(socket);
            });  //创建一个工作线程
            workThread.start();  //启动工作线程
        }
    }

    public static void main(String args[]) throws IOException {
        new EchoServer().service();
    }
}