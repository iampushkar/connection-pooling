package com.lld.pooling;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private final int MAX_POOL_SIZE = 10;
    private final BlockingQueue<Connection> pool;

    public ConnectionPool() throws SQLException {
        pool = new ArrayBlockingQueue<>(MAX_POOL_SIZE);
        for (int i=0; i<MAX_POOL_SIZE; i++) {
            Connection connection = DBConnection.createConnection();
            pool.add(connection);
        }
    }

    public Connection getConnection() throws InterruptedException {
        return pool.take();
    }

    public void releaseConnection(Connection connection) throws SQLException {
        if (null !=  connection && !connection.isClosed())
            pool.offer(connection);
    }

    public void shutdown() throws SQLException {
        for (Connection connection : pool) {
            if (null != connection && !connection.isClosed())
                connection.close();
        }
    }
}
