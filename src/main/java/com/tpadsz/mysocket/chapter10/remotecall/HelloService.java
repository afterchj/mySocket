package com.tpadsz.mysocket.chapter10.remotecall;

import java.util.Date;

public interface HelloService {
    String echo(String msg);

    Date getTime();
} 

