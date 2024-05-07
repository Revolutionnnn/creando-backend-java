package com.example;

import java.sql.*;

import com.utils.DatabaseConnetion;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (
            Connection myConn = DatabaseConnetion.getInstance();
            Statement myStant = myConn.createStatement();
            ResultSet myRest = myStant.executeQuery("SELECT * FROM employees");
        ){
            while(myRest.next()){
                System.out.println(myRest.getString("first_name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}