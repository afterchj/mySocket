package com.tpadsz.mysocket.chapter10.proxy1;

public class SimpleClient {
    public static void main(String args[]) throws Exception {
        //创建静态代理类实例
        HelloService helloService1 = new HelloServiceProxy("localhost", 8000);
        System.out.println(helloService1.echo("hello"));
        System.out.println(helloService1.getTime());

        //创建动态代理类实例
        HelloService helloService2 = (HelloService) ProxyFactory.getProxy(HelloService.class, "localhost", 8000);
        System.out.println(helloService2.echo("hello"));
        System.out.println(helloService2.getTime());
    }
}

