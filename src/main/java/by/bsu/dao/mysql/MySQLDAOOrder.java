package by.bsu.dao.mysql;

import by.bsu.dao.DAOOrder;
import by.bsu.db.ConnectionPool;
import by.bsu.exception.ConnectionPoolException;
import by.bsu.exception.dao.DAOOrderException;
import by.bsu.model.Order;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAOOrder implements DAOOrder {
    private final static Logger logger = Logger.getLogger(MySQLDAOOrder.class);

    private static final String GET_ALL_ORDERS = "SELECT * FROM rentcardb.order";
    private static final String GET_ORDER_BY_ID = "SELECT * FROM rentcardb.order WHERE orderID=?";
    private static final String GET_ORDERS_BY_ACC_ID = "SELECT DISTINCT * FROM rentcardb.order WHERE accountID=?";

    private static final String INSERT_NEW_ORDER = "INSERT INTO rentcardb.order(accountID, carID, startDate, finishDate) VALUES(?,?,?,?)";

    private static final String DELETE_ORDER_BY_ID = "DELETE FROM rentcardb.order WHERE orderID=?";

    private static final String UPDATE_START_DATE = "UPDATE rentcardb.order SET startDate=? WHERE orderID=?";
    private static final String UPDATE_FINISH_DATE = "UPDATE rentcardb.order SET finishDate=? WHERE orderID=?";

    PreparedStatement preparedStatement;

    private static MySQLDAOOrder ourInstance = new MySQLDAOOrder();

    public static MySQLDAOOrder getInstance() {
        return ourInstance;
    }

    @Override
    public List<Order> getAllOrders() throws DAOOrderException {
        List<Order> orders = null;
        try {
            orders = new ArrayList<Order>();
            Connection connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_ORDERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("orderID"));
                order.setAccId(resultSet.getInt("accountID"));
                order.setCarId(resultSet.getInt("carID"));
                order.setStartDate(resultSet.getDate("startDate"));
                order.setFinishDate(resultSet.getDate("finishDate"));
                orders.add(order);
            }
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOOrderException();
        }
        return orders;
    }

    @Override
    public List<Order> getOrdersByAccId(int accId) throws DAOOrderException {
        List<Order> orders = null;
        try {
            orders = new ArrayList<Order>();
            Connection connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(GET_ORDERS_BY_ACC_ID);
            preparedStatement.setInt(1, accId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("orderID"));
                order.setAccId(resultSet.getInt("accountID"));
                order.setCarId(resultSet.getInt("carID"));
                order.setStartDate(resultSet.getDate("startDate"));
                order.setFinishDate(resultSet.getDate("finishDate"));
                orders.add(order);
            }
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOOrderException();
        }
        return orders;
    }

    @Override
    public Order getOrderById(int id) throws DAOOrderException {
        Order order = new Order();
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(GET_ORDER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                order.setId(resultSet.getInt("orderID"));
                order.setAccId(resultSet.getInt("accountID"));
                order.setCarId(resultSet.getInt("carID"));
                order.setStartDate(resultSet.getDate("startDate"));
                order.setFinishDate(resultSet.getDate("finishDate"));
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOOrderException();
        }
        return order;
    }

    @Override
    public void addOrder(Order order) throws DAOOrderException {
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(INSERT_NEW_ORDER);
            preparedStatement.setInt(1, order.getAccId());
            preparedStatement.setInt(2, order.getCarId());
            preparedStatement.setDate(3, (Date) order.getStartDate());
            preparedStatement.setDate(4, (Date) order.getFinishDate());
            preparedStatement.execute();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOOrderException();
        }
    }

    @Override
    public void updateStartDate(int id, Date d) throws DAOOrderException {
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(UPDATE_START_DATE);
            preparedStatement.setDate(1, d);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOOrderException();
        }
    }

    @Override
    public void updateFinishDate(int id, Date d) throws DAOOrderException {
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(UPDATE_FINISH_DATE);
            preparedStatement.setDate(1, d);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOOrderException();
        }
    }

    @Override
    public void deleteOrderById(int id) throws DAOOrderException {
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(DELETE_ORDER_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOOrderException();
        }
    }
}
