package com.bemach.ws.server;

import com.bemach.data.DbConfig;
/**
 * Make sure to download MySQL JDBC Driver from the website
 * Extract it, and include this file (name may be changed between
 * release): mysql-connector-java-5.1.24-bin.jar into your classpath
 *
 */
public class SvrConfig {
    private String listenHostname = "localhost";
    private String listenPort = "9999";
    private String listenInterface = "HelloWorld";
    private String listenProtocol = "http";
    private DbConfig dbCfg = new DbConfig();
    public DbConfig getDbCfg() {
        return dbCfg;
    }
    public void setDbCfg(DbConfig dbCfg) {
        this.dbCfg = dbCfg;
    }
    public String getListenHostname() {
        return listenHostname;
    }
    public void setListenHostname(String listenHostname) {
        this.listenHostname = listenHostname;
    }
    public String getListenPort() {
        return listenPort;
    }
    public void setListenPort(String listenPort) {
        this.listenPort = listenPort;
    }
    public String getListenInterface() {
        return listenInterface;
    }
    public void setListenInterface(String listenInterface) {
        this.listenInterface = listenInterface;
    }
    public String getListenProtocol() {
        return listenProtocol;
    }
    public void setListenProtocol(String listenProtocol) {
        this.listenProtocol = listenProtocol;
    }
}