package com.company.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.core.env.Environment;

public class SshConnection {

    private Session sshSession;

    public SshConnection(Environment environment) throws Throwable {
        JSch jsch = new JSch();
        sshSession = jsch.getSession(environment.getProperty("ssh.username"),
                                     environment.getProperty("ssh.host"),
                                     environment.getProperty("ssh.port", Integer.class));
        sshSession.setPassword(environment.getProperty("ssh.password"));
        sshSession.setConfig("StrictHostKeyChecking", "no");
        sshSession.connect();
        sshSession.setPortForwardingL(environment.getProperty("local_port", Integer.class),
                                      environment.getProperty("database.host"),
                                      environment.getProperty("database.port", Integer.class));
    }

    public void closeSsh() {
        sshSession.disconnect();
    }

}
