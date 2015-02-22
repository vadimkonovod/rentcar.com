package by.bsu.service.impl;


import by.bsu.dao.DAOCar;
import by.bsu.dao.factory.DAOFactory;
import by.bsu.exception.service.CarServiceException;
import by.bsu.exception.dao.DAOCarException;
import by.bsu.exception.service.OrderServiceException;
import by.bsu.model.Car;
import by.bsu.model.Order;
import by.bsu.service.CarService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarServiceImpl implements CarService {
    private final static Logger logger = Logger.getLogger(CarServiceImpl.class);

    private static CarServiceImpl instance = new CarServiceImpl();

    public static CarServiceImpl getInstance() {
        return instance;
    }

    private DAOCar car = DAOFactory.getDAOFactory("MySQL").getDAOCar();

    @Override
    public Car getCarById(int carId) throws CarServiceException {
        try {
            return car.getCarById(carId);
        } catch (DAOCarException e) {
            logger.error(e.getStackTrace());
            throw new CarServiceException();
        }
    }

    @Override
    public List<Car> getCars() throws CarServiceException {
        try {
            return car.getAllCars();
        } catch (DAOCarException e) {
            logger.error(e.getStackTrace());
            throw new CarServiceException();
        }
    }

    @Override
    public List<Car> getCarsInCity(String city) throws CarServiceException {
        try {
            return car.getCarsInCity(city);
        } catch (DAOCarException e) {
            logger.error(e.getStackTrace());
            throw new CarServiceException();
        }
    }

    @Override
    public List<Car> searchCars(String city, long startDate, long finDate) throws CarServiceException, OrderServiceException {

        List<Car> cars = null;
        cars = new ArrayList<Car>(getCars());
        List<Order> orders = new ArrayList<Order>(OrderServiceImpl.getInstance().getOrders());
        List<Car> carsInCity = new ArrayList<Car>();

        if ("all".equalsIgnoreCase(city)) {
            carsInCity.addAll(cars);
        } else {
            carsInCity.addAll(getCarsInCity(city));
        }

        Iterator<Car> iterator = carsInCity.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            for (Order o : orders) {
                if (o.getCarId() == car.getId()) {
                    if ((startDate <= o.getFinishDate().getTime()) && (finDate >= o.getStartDate().getTime())) {
                        iterator.remove();
                        break;
                    }
                }
            }

        }
        return carsInCity;
    }

    @Override
    public void addCar(String brand, String model, String year, String city) throws NumberFormatException, CarServiceException {
        Car c = new Car();
        c.setBrand(brand);
        c.setModel(model);
        c.setYear(Integer.parseInt(year));
        c.setCity(city);
        try {
            car.addCar(c);
        } catch (DAOCarException e) {
            logger.error(e.getStackTrace());
            throw new CarServiceException();
        }
    }

    @Override
    public void updateCity(int id, String city) throws CarServiceException {
        try {
            car.updateCity(id, city);
        } catch (DAOCarException e) {
            logger.error(e.getStackTrace());
            throw new CarServiceException();
        }
    }

    @Override
    public void deleteCar(int id) throws CarServiceException {
        try {
            car.deleteCarById(id);
        } catch (DAOCarException e) {
            logger.error(e.getStackTrace());
            throw new CarServiceException();
        }
    }
}
