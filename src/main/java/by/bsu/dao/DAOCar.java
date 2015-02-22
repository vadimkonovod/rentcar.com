package by.bsu.dao;

import by.bsu.exception.dao.DAOCarException;
import by.bsu.model.Car;

import java.util.List;

public interface DAOCar {
    public Car getCarById(int carId) throws DAOCarException;
    public List<Car> getAllCars() throws DAOCarException;
    public List<Car> getCarsInCity(String city) throws DAOCarException;

    public void addCar(Car car) throws DAOCarException;

    public void deleteCarById(int id) throws DAOCarException;

    public void updateCity(int id, String city) throws DAOCarException;

}
