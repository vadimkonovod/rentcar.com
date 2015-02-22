package by.bsu.dao.factory;

import by.bsu.dao.DAOAccount;
import by.bsu.dao.DAOCar;
import by.bsu.dao.DAOOrder;
import by.bsu.dao.DAOOrderCarAcc;

public abstract class DAOFactory {

    public DAOFactory() {
    }

    public static DAOFactory getDAOFactory(String factoryType) {
        if (factoryType.equalsIgnoreCase("MySQL")) {
            return new MySQLDAOFactory();
        }
        else {
            return null;
        }
    }

    public abstract DAOAccount getDAOAccount();
    public abstract DAOCar getDAOCar();
    public abstract DAOOrder getDAOOrder();
    public abstract DAOOrderCarAcc getDAOOrderCarAcc();

}
