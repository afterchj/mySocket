package com.tpadsz.mysocket.chapter11.flight;

import java.rmi.*;

public interface FlightFactory extends Remote {
    Flight getFlight(String flightNumber) throws RemoteException;
}
