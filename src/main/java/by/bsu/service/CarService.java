package by.bsu.service;

import by.bsu.exception.service.CarServiceException;
import by.bsu.exception.dao.DAOCarException;
import by.bsu.exception.service.OrderServiceException;
import by.bsu.model.Car;

import java.util.List;

public interface CarService {
    public Car getCarById(int carId) throws DAOCarException, CarServiceException;
    public List<Car> getCars() throws DAOCarException, CarServiceException;
    public List<Car> getCarsInCity(String city) throws DAOCarException, CarServiceException;
    public List<Car> searchCars(String city, long startDate, long finDate) throws DAOCarException, CarServiceException, OrderServiceException;
    public void addCar(String brand, String model, String year, String city) throws DAOCarException, CarServiceException;
    public void deleteCar(int id) throws DAOCarException, CarServiceException;
    public void updateCity(int id, String city) throws DAOCarException, CarServiceException;

}
