package by.bsu.service;

import by.bsu.exception.service.OrderServiceException;
import by.bsu.model.Order;

import java.sql.Date;
import java.util.List;

public interface OrderService {
    public List<Order> getOrders() throws OrderServiceException;
    public List<Order> getOrdersByAccId(int accId) throws OrderServiceException;
    public Order getOrderById(int id) throws OrderServiceException;
    public void addOrder(Order o) throws OrderServiceException;
    public void deleteOrder(int id) throws OrderServiceException;
    public void updateStartDate(int id, Date d) throws OrderServiceException;
    public void updateFinishDate(int id, Date d) throws OrderServiceException;

}
