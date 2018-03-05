package com.tpadsz.mysocket.chapter06.echo;

import java.net.*;
import java.io.*;

public class EchoURLStreamHandlerFactory implements URLStreamHandlerFactory {
    public URLStreamHandler createURLStreamHandler(String protocol) {
        if (protocol.equals("echo"))
            return new EchoURLStreamHandler();
        else
            return null;
    }
}
