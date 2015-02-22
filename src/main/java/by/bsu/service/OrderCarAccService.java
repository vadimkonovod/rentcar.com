package by.bsu.service;

import by.bsu.exception.service.OrderCarAccServiceException;
import by.bsu.model.OrderCarAcc;

import java.util.List;

public interface OrderCarAccService {
    public List<OrderCarAcc> getOrdersAndCarsByAccId(int accId) throws OrderCarAccServiceException;
    public List<OrderCarAcc> getAllOrders() throws OrderCarAccServiceException;
}
