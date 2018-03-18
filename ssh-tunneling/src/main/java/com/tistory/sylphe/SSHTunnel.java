package com.tistory.sylphe;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.Properties;

public class SSHTunnel {

    public static void connectSshTunnel(String sshHost, int sshPort, String sshUser, String sshPassword, String remoteHost, int localPort, int remotePort) {
        final JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(sshUser, sshHost, sshPort);
            session.setPassword(sshPassword);

            final Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect();
            session.setPortForwardingL(localPort, remoteHost, remotePort);
        } catch (JSchException e) {
            e.printStackTrace();
        }

    }

}