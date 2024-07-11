package com.yusuf.jdbc;

public class DbProperties {

    private String dbUser;
    private String dbPassword;
    private String dbHost;
    private String dbPort;
    private String dbName;

    public DbProperties(String dbUser, String dbPassword, String dbHost, String dbPort, String dbName) {
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.dbHost = dbHost;
        this.dbPort = dbPort;
        this.dbName = dbName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbHost() {
        return dbHost;
    }

    public String getDbPort() {
        return dbPort;
    }

    public String getDbName() {
        return dbName;
    }
}
