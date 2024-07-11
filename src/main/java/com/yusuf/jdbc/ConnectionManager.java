package com.yusuf.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static final ConnectionManager SELF = new ConnectionManager();
    private Connection connection;

    private ConnectionManager() {
        try {
            register();
            DbProperties properties = readDbProperties();
            connection = DriverManager.getConnection(
                    String.format("jdbc:postgresql://%s:%s/%s?user=%s&password=%s", properties.getDbHost()
                    , properties.getDbPort(), properties.getDbName(), properties.getDbUser(), properties.getDbPassword()));
        } catch (SQLException e) {
            System.exit(1);
        }
    }

    private DbProperties readDbProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.exit(1);
            }
            prop.load(input);
            String dbuser = prop.getProperty("db.user");
            String dbpassword = prop.getProperty("db.password");
            String dbHost = prop.getProperty("db.host");
            String dbPort = prop.getProperty("db.port");
            String dbName = prop.getProperty("db.databaseName");
            return new DbProperties(dbuser, dbpassword, dbHost, dbPort, dbName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void register() throws SQLException {
        Driver registeredDriver = new org.postgresql.Driver();
        DriverManager.registerDriver(registeredDriver);
    }

    public static ConnectionManager getInstance() {
        return SELF;
    }

    public  Connection getConnection() {
        return connection;
    }
}
