package com.tistory.sylphe;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SSHTunnelTest{

    @Test
    public void sshTunnelConnectTest() throws SQLException, ClassNotFoundException {
        String sshHost = "xxx.xxx.xxx.xxx";
        String remoteHost = "xxx.xxx.xxx.xxx";
        String sshUser = "xxxx";
        String sshPw="xxxxx";
        int sshPort = 81;
        int localPort = 81;                                // local port number use to bind SSH tunnel
        int remotePort = 3306;                               // remote port number of your database

        SSHTunnel.connectSshTunnel(sshHost,sshPort,sshUser,sshPw, remoteHost,localPort,remotePort);

        String dbUser = "xxx";                    // database loging username
        String dbPassword = "xxxxx";                    // database login password

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:"+localPort+"?useSSL=false", dbUser, dbPassword);

        con.close();
    }

}