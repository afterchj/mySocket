package com.tpadsz.mysocket.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by hongjian.chen on 2018/3/5.
 */
public class PortScanner {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getByName("baidu.com").getHostAddress());
        String host="localhost";
//        if (args.length>0){
//            host=args[0];
//        }
//        new PortScanner().scan(host);
    }

    private  void scan(String host) {
        Socket socket=null;
        for (int port=7999;port<8008;port++){
            try {
                socket=new Socket(host,port);
                System.out.println("This port already in use: JVM_Bind:"+port);
            } catch (IOException e) {
                System.out.println("Can't connect to port "+port);
            }finally {
                try {
                    if (socket!=null){
                        socket.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
