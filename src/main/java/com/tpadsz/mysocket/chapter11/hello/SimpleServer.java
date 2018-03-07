package com.tpadsz.mysocket.chapter11.hello;

import javax.naming.*;

public class SimpleServer {
    public static void main(String args[]) {
        try {
            HelloService service1 = new HelloServiceImpl("service1");
            HelloService service2 = new HelloServiceImpl("service2");

            Context namingContext = new InitialContext();
            namingContext.rebind("rmi:HelloService1", service1);
            namingContext.rebind("rmi:HelloService2", service2);

//            namingContext.rebind("rmi://localhost:8000/HelloService1", service1);
//            namingContext.rebind("rmi://localhost:8000/HelloService1", service2);

            System.out.println("服务器注册了两个HelloService对象");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}