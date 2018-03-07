package com.tpadsz.mysocket.chapter11.flight;

import java.rmi.*;

interface Flight extends Remote {
    //读取航班号
    String getFlightNumber() throws RemoteException;

    //读取始发站
    String getOrigin() throws RemoteException;

    //读取终点站
    String getDestination() throws RemoteException;

    //读取计划出发时间
    String getSkdDeparture() throws RemoteException;

    //读取计划到达时间
    String getSkdArrival() throws RemoteException;

    void setOrigin(String origin) throws RemoteException;

    void setDestination(String destination) throws RemoteException;

    void setSkdDeparture(String skdDeparture) throws RemoteException;

    void setSkdArrival(String skdArrival) throws RemoteException;
}
