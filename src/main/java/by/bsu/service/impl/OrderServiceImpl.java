package by.bsu.service.impl;

import by.bsu.dao.DAOOrder;
import by.bsu.dao.factory.DAOFactory;
import by.bsu.exception.dao.DAOOrderException;
import by.bsu.exception.service.OrderServiceException;
import by.bsu.model.Order;
import by.bsu.service.OrderService;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final static Logger logger = Logger.getLogger(OrderServiceImpl.class);

    private static OrderServiceImpl instance = new OrderServiceImpl();

    public static OrderServiceImpl getInstance() {
        return instance;
    }

    DAOOrder order = DAOFactory.getDAOFactory("MySQL").getDAOOrder();

    @Override
    public List<Order> getOrders() throws OrderServiceException {
        try {
            return order.getAllOrders();
        } catch (DAOOrderException e) {
            logger.error(e.getStackTrace());
            throw new OrderServiceException();
        }
    }

    @Override
    public List<Order> getOrdersByAccId(int accId) throws OrderServiceException {
        try {
            return order.getOrdersByAccId(accId);
        } catch (DAOOrderException e) {
            logger.error(e.getStackTrace());
            throw new OrderServiceException();
        }
    }

    @Override
    public Order getOrderById(int id) throws OrderServiceException {
        try {
            return order.getOrderById(id);
        } catch (DAOOrderException e) {
            logger.error(e.getStackTrace());
            throw new OrderServiceException();
        }
    }

    @Override
    public void addOrder(Order o) throws OrderServiceException {
        try {
            order.addOrder(o);
        } catch (DAOOrderException e) {
            logger.error(e.getStackTrace());
            throw new OrderServiceException();
        }
    }

    @Override
    public void deleteOrder(int id) throws OrderServiceException {
        try {
            order.deleteOrderById(id);
        } catch (DAOOrderException e) {
            logger.error(e.getStackTrace());
            throw new OrderServiceException();
        }
    }

    @Override
    public void updateStartDate(int id, Date d) throws OrderServiceException {
        try {
            order.updateStartDate(id, d);
        } catch (DAOOrderException e) {
            logger.error(e.getStackTrace());
            throw new OrderServiceException();
        }
    }

    @Override
    public void updateFinishDate(int id, Date d) throws OrderServiceException {
        try {
            order.updateFinishDate(id, d);
        } catch (DAOOrderException e) {
            logger.error(e.getStackTrace());
            throw new OrderServiceException();
        }
    }
}
