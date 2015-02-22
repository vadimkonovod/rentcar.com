package by.bsu.db;

import by.bsu.exception.ConnectionPoolException;
import by.bsu.util.DBPropertiesUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPool {
    private final static Logger logger = Logger.getLogger(ConnectionPool.class);

    private BlockingQueue<Connection> connectionQueue;
    private BlockingQueue<Connection> givenAwayConQueue;
    private static ConnectionPool pool;

    private String driverName;
    private String url;
    private String user;
    private String password;
    private int poolSize;

    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    public static final String DRIVER = "driver";
    public static final String POOL_SIZE = "poolSize";

    public static ConnectionPool getInstance() throws ConnectionPoolException {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    private ConnectionPool() throws ConnectionPoolException {

        driverName = DBPropertiesUtil.getInstance().getPropByName(DRIVER);
        url = DBPropertiesUtil.getInstance().getPropByName(URL);
        user = DBPropertiesUtil.getInstance().getPropByName(USERNAME);
        password = DBPropertiesUtil.getInstance().getPropByName(PASSWORD);
        try {
            poolSize = Integer.parseInt(
                    DBPropertiesUtil.getInstance().getPropByName(POOL_SIZE));
        } catch (NumberFormatException e) {
            poolSize = 10;
        }
            initPoolData();
    }

    public void initPoolData() throws ConnectionPoolException {
        try {
            Class.forName(driverName);
            givenAwayConQueue = new ArrayBlockingQueue<Connection>(poolSize);
            connectionQueue = new ArrayBlockingQueue<Connection>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                Connection connection =
                        DriverManager.getConnection(url, user, password);
                connectionQueue.add(connection);
            }
        } catch (SQLException e) {
            throw new ConnectionPoolException("SQLException in ConnectionPool", e);
        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException("Can't find database driver class", e);
        }
    }

    private void clearConnectionQueue() {
        try {
            closeConnectionsQueue(givenAwayConQueue);
            closeConnectionsQueue(connectionQueue);
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Error closing the connection.", e);
        }
    }

    public Connection takeConnection() throws ConnectionPoolException {
        Connection connection = null;
        try {
            connection = connectionQueue.take();
            givenAwayConQueue.add(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Error connecting to the data source.", e);
        }
        return connection;
    }

    public void closeConnection(Connection con, Statement st, ResultSet rs) {
        givenAwayConQueue.remove(con);
        connectionQueue.add(con);
    }

    public void closeConnection(Connection con, Statement st) {
        try {
            con.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Connection isn't return to the pool.");
        }

        try {
            st.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Statement isn't closed.");
        }
    }

    private void closeConnectionsQueue(BlockingQueue<Connection> queue) throws SQLException {
        Connection connection;
        while ((connection = queue.poll()) != null) {
            if (!connection.getAutoCommit()) {
                connection.commit();
            }
            connection.close();
        }
    }

}
