package by.bsu.dao.mysql;

import by.bsu.dao.DAOOrderCarAcc;
import by.bsu.db.ConnectionPool;
import by.bsu.exception.ConnectionPoolException;
import by.bsu.exception.dao.DAOOrderCarAccException;
import by.bsu.model.OrderCarAcc;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAOOrderCarAcc implements DAOOrderCarAcc {
    private final static Logger logger = Logger.getLogger(MySQLDAOOrderCarAcc.class);

    private static final String GET_CAR_AND_ORDERS = "SELECT orderID, startDate, finishDate, brand, model, city FROM rentcardb.order AS o LEFT JOIN car AS c ON o.carID=c.carID LEFT JOIN account AS a ON o.accountID=a.accountID WHERE a.accountID=?";
    private static final String GET_ALL_ORDERS = "SELECT * FROM rentcardb.order AS o LEFT JOIN car AS c ON o.carID=c.carID LEFT JOIN account AS a ON o.accountID=a.accountID ORDER BY name;";

    PreparedStatement preparedStatement;
    private static MySQLDAOOrderCarAcc instance = new MySQLDAOOrderCarAcc();

    public static MySQLDAOOrderCarAcc getInstance() {
        return instance;
    }
    @Override
    public List<OrderCarAcc> getOrdersAndCars(int accId) throws DAOOrderCarAccException {
        List<OrderCarAcc> orderCars = null;
        try {
            orderCars = new ArrayList<OrderCarAcc>();
            Connection connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(GET_CAR_AND_ORDERS);
            preparedStatement.setInt(1, accId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OrderCarAcc oc = new OrderCarAcc();
                oc.getOrder().setId(resultSet.getInt("orderID"));
                oc.getOrder().setStartDate(resultSet.getDate("startDate"));
                oc.getOrder().setFinishDate(resultSet.getDate("finishDate"));

                oc.getCar().setBrand(resultSet.getString("brand"));
                oc.getCar().setModel(resultSet.getString("model"));
                oc.getCar().setCity(resultSet.getString("city"));

                orderCars.add(oc);
            }
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOOrderCarAccException();
        }
        return orderCars;
    }

    @Override
    public List<OrderCarAcc> getAllOrders() throws DAOOrderCarAccException {
        List<OrderCarAcc> orderCarAccs = null;
        try {
            orderCarAccs = new ArrayList<OrderCarAcc>();
            Connection connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_ORDERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OrderCarAcc oc = new OrderCarAcc();
                oc.getAccount().setId(resultSet.getInt("accountID"));
                oc.getAccount().setName(resultSet.getString("name"));
                oc.getAccount().setSurname(resultSet.getString("surname"));
                oc.getAccount().setAge(resultSet.getInt("age"));
                oc.getAccount().setEmail(resultSet.getString("email"));
                oc.getAccount().setLogin(resultSet.getString("login"));
                oc.getAccount().setPassword(resultSet.getString("password"));
                oc.getAccount().setRole(resultSet.getString("role"));

                oc.getOrder().setId(resultSet.getInt("orderID"));
                oc.getOrder().setAccId(resultSet.getInt("accountID"));
                oc.getOrder().setCarId(resultSet.getInt("carID"));
                oc.getOrder().setStartDate(resultSet.getDate("startDate"));
                oc.getOrder().setFinishDate(resultSet.getDate("finishDate"));

                oc.getCar().setId(resultSet.getInt("carID"));
                oc.getCar().setBrand(resultSet.getString("brand"));
                oc.getCar().setModel(resultSet.getString("model"));
                oc.getCar().setYear(resultSet.getInt("year"));
                oc.getCar().setCity(resultSet.getString("city"));

                orderCarAccs.add(oc);
            }
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOOrderCarAccException();
        }
        return orderCarAccs;
    }
}
