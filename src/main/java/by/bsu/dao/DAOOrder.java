package by.bsu.dao;

import by.bsu.exception.dao.DAOOrderException;
import by.bsu.model.Order;

import java.sql.Date;
import java.util.List;

public interface DAOOrder {
    public List<Order> getAllOrders() throws DAOOrderException;
    List<Order> getOrdersByAccId(int accId) throws DAOOrderException;
    public Order getOrderById(int id) throws DAOOrderException;

    public void addOrder(Order order) throws DAOOrderException;

    public void deleteOrderById(int id) throws DAOOrderException;

    public void updateStartDate(int id, Date d) throws DAOOrderException;
    public void updateFinishDate(int id, Date d) throws DAOOrderException;

}
