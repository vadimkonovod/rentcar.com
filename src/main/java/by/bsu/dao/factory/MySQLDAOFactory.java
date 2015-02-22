package by.bsu.dao.factory;

import by.bsu.dao.*;
import by.bsu.dao.mysql.MySQLDAOAccount;
import by.bsu.dao.mysql.MySQLDAOCar;
import by.bsu.dao.mysql.MySQLDAOOrder;
import by.bsu.dao.mysql.MySQLDAOOrderCarAcc;

public class MySQLDAOFactory extends DAOFactory {

    public MySQLDAOFactory() {
    }

    public DAOAccount getDAOAccount() {
        return MySQLDAOAccount.getInstance();
    }

    public DAOCar getDAOCar() {
        return MySQLDAOCar.getInstance();
    }

    public DAOOrder getDAOOrder() {
        return MySQLDAOOrder.getInstance();
    }

    public DAOOrderCarAcc getDAOOrderCarAcc() {
        return MySQLDAOOrderCarAcc.getInstance();
    }

}
