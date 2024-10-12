package com.lld.pooling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:h2:mem:testdb";  // H2 In-Memory Database
    private static final String USER = "sa";  // Default H2 user
    private static final String PASSWORD = "";  // No password by default

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    public static void runQuery(Connection connection) throws SQLException {
        var statement = connection.createStatement();
        statement.execute("SELECT 1");
    }
}
