package by.bsu.dao.mysql;

import by.bsu.dao.DAOCar;
import by.bsu.db.ConnectionPool;
import by.bsu.exception.ConnectionPoolException;
import by.bsu.exception.dao.DAOCarException;
import by.bsu.model.Car;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAOCar implements DAOCar {
    private final static Logger logger = Logger.getLogger(MySQLDAOCar.class);

    private static final String GET_ALL_CARS = "SELECT * FROM car ORDER BY brand";
    private static final String GET_CAR_BY_ID = "SELECT * FROM car WHERE carID=?";
    private static final String GET_CARS_IN_CITY = "SELECT * FROM car WHERE city=?";
    private static final String INSERT_NEW_CAR = "INSERT INTO car(brand, model, year, city) VALUES(?,?,?,?)";
    private static final String DELETE_CAR_BY_ID = "DELETE FROM car WHERE carID=?";
    private static final String UPDATE_CITY = "UPDATE car SET city=? WHERE carID = ?";

    PreparedStatement preparedStatement;

    private static MySQLDAOCar ourInstance = new MySQLDAOCar();

    public static MySQLDAOCar getInstance() {
        return ourInstance;
    }

    @Override
    public Car getCarById(int carId) throws DAOCarException {
        Car car = null;
        try {
            car = new Car();
            Connection connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(GET_CAR_BY_ID);
            preparedStatement.setInt(1, carId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                car.setId(resultSet.getInt("carID"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getInt("year"));
                car.setCity(resultSet.getString("city"));
            }
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOCarException();
        }
        return car;
    }

    @Override
     public List<Car> getAllCars() throws DAOCarException {
        List<Car> cars = null;
        try {
            cars = new ArrayList<Car>();
            Connection connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_CARS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Car car = new Car();
                car.setId(resultSet.getInt("carID"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getInt("year"));
                car.setCity(resultSet.getString("city"));
                cars.add(car);
            }
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOCarException();
        }
        return cars;
    }

    @Override
    public List<Car> getCarsInCity(String city) throws DAOCarException {
        List<Car> cars = null;
        try {
            cars = new ArrayList<Car>();
            Connection connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(GET_CARS_IN_CITY);
            preparedStatement.setString(1, city);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Car car = new Car();
                car.setId(resultSet.getInt("carID"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getInt("year"));
                car.setCity(resultSet.getString("city"));
                cars.add(car);
            }
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOCarException();
        }
        return cars;
    }


    @Override
    public void addCar(Car car) throws DAOCarException {
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(INSERT_NEW_CAR);
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setString(4, car.getCity());
            preparedStatement.execute();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOCarException();
        }
    }

    @Override
    public void deleteCarById(int id) throws DAOCarException {
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(DELETE_CAR_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOCarException();
        }
    }

    @Override
    public void updateCity(int id, String city) throws DAOCarException {
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(UPDATE_CITY);
            preparedStatement.setString(1, city);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOCarException();
        }
    }
}
