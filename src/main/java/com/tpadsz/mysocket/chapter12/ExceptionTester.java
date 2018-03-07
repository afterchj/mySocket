package com.tpadsz.mysocket.chapter12;

import java.sql.*;
import java.io.*;

public class ExceptionTester {
    public static void main(String args[]) {
        try {
            Connection con = new ConnectionProvider().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select FIRSTNAME from CUSTOMERS");

//            while (rs.next()) {
//                long id = rs.getLong(1);
//                String name = rs.getString(2);
//                int age = rs.getInt(3);
//                String address = rs.getString(4);
//
//                //打印所显示的数据
//                System.out.println("id=" + id + ",name=" + name + ",age=" + age + ",address=" + address);
//            }

        } catch (SQLException e) {
            System.out.println("ErrorCode:" + e.getErrorCode());
            System.out.println("SQLState:" + e.getSQLState());
            System.out.println("Reason:" + e.getMessage());
        }
    }
} 
