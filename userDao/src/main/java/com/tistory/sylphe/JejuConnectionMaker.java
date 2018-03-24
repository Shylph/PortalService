package com.tistory.sylphe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JejuConnectionMaker implements ConnectionMaker{
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //return DriverManager.getConnection("jdbc:mysql://192.168.0.54/jeju?characterEncoding=utf-8", "jeju", "jejupw");
        return DriverManager.getConnection("jdbc:mysql://localhost:81/ksh_test?useSSL=false&characterEncoding=utf-8", "ksh", "qwer1234");
    }
}
