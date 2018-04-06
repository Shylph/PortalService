package com.tistory.sylphe;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JejuConnectionMaker implements ConnectionMaker{

    @Value("${db.classname}")
    private String className;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        /*className = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:81/ksh_test?useSSL=false&characterEncoding=utf-8";
        username = "ksh";
        password = "qwer1234";
        */
        Class.forName(className);
        return DriverManager.getConnection(url, username, password);
    }
}
