package com.tpadsz.mysocket.chapter12;

import java.sql.*;
import javax.sql.DataSource;
import java.io.*;
import java.util.logging.Logger;

public class DataSourceImpl implements DataSource {
    private ConnectionPool pool = new ConnectionPoolImpl2();

    public Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    public Connection getConnection(String username, String password) throws SQLException {
        throw new UnsupportedOperationException();
    }

    public int getLoginTimeout() throws SQLException {
        return DriverManager.getLoginTimeout();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public PrintWriter getLogWriter() throws SQLException {
        return DriverManager.getLogWriter();
    }

    public void setLoginTimeout(int seconds) throws SQLException {
        DriverManager.setLoginTimeout(seconds);
    }

    public void setLogWriter(PrintWriter out) throws SQLException {
        DriverManager.setLogWriter(out);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
