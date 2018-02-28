package com.tpadsz.mysocket.chapter02;

import java.net.*;

public class SimpleServer {
    public static void main(String args[]) throws Exception {
        //连接请求队列的长度为2
        ServerSocket serverSocket = new ServerSocket(8000, 2);
        Thread.sleep(360000);   //睡眠6分钟
    }
}


