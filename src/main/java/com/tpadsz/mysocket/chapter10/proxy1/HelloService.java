package com.tpadsz.mysocket.chapter10.proxy1;

import java.util.Date;

public interface HelloService {
    String echo(String msg) throws RemoteException;

    Date getTime() throws RemoteException;
} 
