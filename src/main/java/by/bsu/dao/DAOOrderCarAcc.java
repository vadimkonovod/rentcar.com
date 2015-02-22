package by.bsu.dao;

import by.bsu.exception.dao.DAOOrderCarAccException;
import by.bsu.model.OrderCarAcc;

import java.util.List;

public interface DAOOrderCarAcc {
    public List<OrderCarAcc> getOrdersAndCars(int accId) throws DAOOrderCarAccException;
    public List<OrderCarAcc> getAllOrders() throws DAOOrderCarAccException;
}
