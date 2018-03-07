package com.tpadsz.mysocket.chapter11.flight;

import javax.naming.*;

public class SimpleServer {
    public static void main(String args[]) {
        try {
            FlightFactory factory = new FlightFactoryImpl();

            Context namingContext = new InitialContext();
            namingContext.rebind("rmi:FlightFactory", factory);

            System.out.println("服务器注册了一个FlightFactory对象");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
