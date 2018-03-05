package com.tpadsz.mysocket.chapter05;

import java.io.*;
import java.nio.channels.*;

public interface Handler {
    void handle(SelectionKey key) throws IOException;
}
