package com.tpadsz.mysocket.chapter11.hello;

import java.util.Date;
import java.rmi.*;

public interface HelloService extends Remote {
    String echo(String msg) throws RemoteException;

    Date getTime() throws RemoteException;
} 
