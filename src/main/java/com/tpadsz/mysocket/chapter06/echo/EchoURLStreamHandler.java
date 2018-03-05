package com.tpadsz.mysocket.chapter06.echo;

import java.net.*;
import java.io.*;

public class EchoURLStreamHandler extends URLStreamHandler {
    public int getDefaultPort() {
        return 8001;
    }

    protected URLConnection openConnection(URL url) throws IOException {
        return new EchoURLConnection(url);
    }
}

