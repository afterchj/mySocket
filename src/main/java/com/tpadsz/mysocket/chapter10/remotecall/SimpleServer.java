package com.tpadsz.mysocket.chapter10.remotecall;

import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.reflect.*;

public class SimpleServer {
    private Map remoteObjects = new HashMap();

    public void register(String className, Object remoteObject) {
        remoteObjects.put(className, remoteObject);
    }

    public void service() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("服务器启动...");
        while (true) {
            Socket socket = serverSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Call call = (Call) ois.readObject();
            System.out.println("客户端调用的类和方法："+call);
            call = invoke(call);
            oos.writeObject(call);

            ois.close();
            oos.close();
            socket.close();
        }
    }

    public Call invoke(Call call) {
        Object result;
        try {
            String className = call.getClassName();
            String methodName = call.getMethodName();
            Object[] params = call.getParams();
            Class classType = Class.forName(className);
            Class[] paramTypes = call.getParamTypes();
            Method method = classType.getMethod(methodName, paramTypes);
            Object remoteObject = remoteObjects.get(className);
            if (remoteObject != null) {
                result = method.invoke(remoteObject, params);
            } else {
                throw new Exception(className + "的远程对象不存在");
            }
        } catch (Exception e) {
            result = e;
        }

        call.setResult(result);
        return call;
    }

    public static void main(String args[]) throws Exception {
        SimpleServer server = new SimpleServer();
        server.register("com.tpadsz.mysocket.chapter10.remotecall.HelloService", new HelloServiceImpl());
        server.service();
    }
}
