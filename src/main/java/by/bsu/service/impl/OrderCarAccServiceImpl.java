package by.bsu.service.impl;

import by.bsu.dao.DAOOrderCarAcc;
import by.bsu.dao.factory.DAOFactory;
import by.bsu.exception.dao.DAOOrderCarAccException;
import by.bsu.exception.service.OrderCarAccServiceException;
import by.bsu.model.OrderCarAcc;
import by.bsu.service.OrderCarAccService;
import org.apache.log4j.Logger;

import java.util.List;

public class OrderCarAccServiceImpl implements OrderCarAccService {
    private final static Logger logger = Logger.getLogger(OrderCarAccServiceImpl.class);

    private static OrderCarAccServiceImpl instance = new OrderCarAccServiceImpl();

    public static OrderCarAccServiceImpl getInstance() {
        return instance;
    }

    private DAOOrderCarAcc orderCar = DAOFactory.getDAOFactory("MySQL").getDAOOrderCarAcc();

    @Override
    public List<OrderCarAcc> getOrdersAndCarsByAccId(int accId) throws OrderCarAccServiceException {
        try {
            return orderCar.getOrdersAndCars(accId);
        } catch (DAOOrderCarAccException e) {
            logger.error(e.getStackTrace());
            throw new OrderCarAccServiceException();
        }
    }

    @Override
    public List<OrderCarAcc> getAllOrders() throws OrderCarAccServiceException {
        try {
            return orderCar.getAllOrders();
        } catch (DAOOrderCarAccException e) {
            logger.error(e.getStackTrace());
            throw new OrderCarAccServiceException();
        }
    }
}
