package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnetion {
    private static final String url = "jdbc:mysql://localhost:3306/project";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection myConn;
    public static Connection getInstance() throws SQLException {
        if (myConn == null) {
            myConn = DriverManager.getConnection(url,user,password);
        }
        return myConn;
    }
}
