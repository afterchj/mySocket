package com.tpadsz.mysocket.chapter10.proxy;

public class Client2 {
    public static void main(String args[]) {
        HelloService helloService = new HelloServiceImpl();
        HelloService helloServiceProxy = HelloServiceProxyFactory.getHelloServiceProxy(helloService);
        System.out.println("动态代理类的名字：" + helloServiceProxy.getClass().getName());
        System.out.println(helloServiceProxy.echo("Hello"));
    }
}

