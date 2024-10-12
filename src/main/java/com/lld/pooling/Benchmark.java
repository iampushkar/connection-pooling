package com.lld.pooling;

import java.sql.Connection;
import java.sql.SQLException;

public class Benchmark {

    private static final int MAX_ITERATION = 10000;

    public static void benchmarkWithoutPooling() throws SQLException {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < MAX_ITERATION; i++) {
            Connection connection = DBConnection.createConnection();
            DBConnection.runQuery(connection);
            connection.close();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken without Pooling: " + (endTime - startTime) + " ms");
    }

    public static void benchmarkWithConnectionPooling(ConnectionPool pool) throws SQLException, InterruptedException {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < MAX_ITERATION; i++) {
            Connection connection = pool.getConnection();
            DBConnection.runQuery(connection);
            pool.releaseConnection(connection);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken with Connection Pooling: " + (endTime - startTime) + " ms");
    }
}
