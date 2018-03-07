package com.tpadsz.mysocket.chapter12;

import java.sql.*;

public interface ConnectionPool {
    /**
     * 从连接池中取出连接
     */
     Connection getConnection() throws SQLException;

    /**
     * 把连接返回连接池
     */
     void releaseConnection(Connection con) throws SQLException;

    /**
     * 关闭连接池
     */
    void close();
}

