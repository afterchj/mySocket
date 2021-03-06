package com.tpadsz.mysocket.chapter10.proxy1;

import java.lang.reflect.*;

public class ProxyFactory {
    public static Object getProxy(final Class classType, final String host, final int port) {
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object args[]) throws Exception {
                Connector connector = null;
                try {
                    connector = new Connector(host, port);
                    Call call = new Call(classType.getName(), method.getName(), method.getParameterTypes(), args);
                    connector.send(call);
                    call = (Call) connector.receive();
                    Object result = call.getResult();
                    if (result instanceof Throwable)
                        throw new RemoteException((Throwable) result);
                    else
//                        System.out.println("result="+proxy.getClass().getSimpleName()+"\t"+method.getName());
                        return result;
                } finally {
                    if (connector != null) connector.close();
                }
            }
        };

        return Proxy.newProxyInstance(classType.getClassLoader(), new Class[]{classType}, handler);
    }
}

