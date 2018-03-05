package com.tpadsz.mysocket.chapter06.echo;

import java.net.*;

public class EchoContentHandlerFactory implements ContentHandlerFactory {
    public ContentHandler createContentHandler(String mimetype) {
        if (mimetype.equals("text/plain")) {
            return new EchoContentHandler();
        } else {
            return null;
        }
    }
}
