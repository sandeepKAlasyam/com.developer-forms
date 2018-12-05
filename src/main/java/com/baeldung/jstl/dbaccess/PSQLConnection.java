package com.baeldung.jstl.dbaccess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PSQLConnection {
    private static String userName = "postgres";
    private static String password = "admin";
    private static final Logger LOGGER = LoggerFactory.getLogger(PSQLConnection.class.getName());

    public static Connection getConnection() throws Exception {
        LOGGER.error("connecting...");
        Class.forName("org.postgresql.Driver");
        LOGGER.error("class checked...");
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);
        conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/BellInfoBatch11?autoReconnect=true&useSSL=false",
                connectionProps);
        LOGGER.info("Connected to database");
        return conn;
    }
}
