package by.bsu.service.impl;

import by.bsu.dao.DAOAccount;
import by.bsu.dao.factory.DAOFactory;
import by.bsu.exception.*;
import by.bsu.exception.dao.DAOAccountException;
import by.bsu.exception.service.AccountServiceException;
import by.bsu.model.Account;
import by.bsu.service.AccountService;
import by.bsu.util.Validator;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final static Logger logger = Logger.getLogger(AccountServiceImpl.class);

    private static AccountServiceImpl instance = new AccountServiceImpl();

    public static AccountServiceImpl getInstance() {
        return instance;
    }

    private DAOAccount account = DAOFactory.getDAOFactory("MySQL").getDAOAccount();

    @Override
    public boolean checkLogin(String enterLogin, String enterPass) throws AccountServiceException {
        Account a = null;
        try {
            a = account.getAccountByLogin(enterLogin);
            return a != null && a.getPassword().equals(enterPass);
        } catch (DAOAccountException e) {
            logger.error(e.getStackTrace());
            throw new AccountServiceException();
        }
    }

    @Override
    public void regAccount(String name, String surnname, String age, String email, String login, String password, String verpassword) throws IllegalEmailValidationException, SQLException, IllegalPasswordValidationException, AccountServiceException {
        Account a = new Account();
        a.setName(name);
        a.setSurname(surnname);
        a.setAge(Integer.parseInt(age));
        Validator.emailValidate(email, "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" );
        a.setEmail(email);
        a.setLogin(login);
        Validator.passwordValidate(password, verpassword);
        a.setPassword(password);
        try {
            account.addAccount(a);
        } catch (DAOAccountException e) {
            logger.error(e.getStackTrace());
            throw new AccountServiceException();
        }
    }

    @Override
    public List<Account> getAccounts() throws AccountServiceException {
        try {
            return account.getAllAccounts();
        } catch (DAOAccountException e) {
            logger.error(e.getStackTrace());
            throw new AccountServiceException();
        }
    }

    @Override
    public Account getAccountById(int id) throws AccountServiceException {
        try {
            return account.getAccountById(id);
        } catch (DAOAccountException e) {
            logger.error(e.getStackTrace());
            throw new AccountServiceException();
        }
    }

    @Override
    public Account getAccountByLogin(String login) throws AccountServiceException {
        try {
            return account.getAccountByLogin(login);
        } catch (DAOAccountException e) {
            logger.error(e.getStackTrace());
            throw new AccountServiceException();
        }
    }

    @Override
    public void addAccount(Account a) throws AccountServiceException, SQLException {
        try {
            account.addAccount(a);
        } catch (DAOAccountException e) {
            logger.error(e.getStackTrace());
            throw new AccountServiceException();
        }
    }

    @Override
    public void deleteAccount(int id) throws AccountServiceException {
        try {
            account.deleteAccountById(id);
        } catch (DAOAccountException e) {
            logger.error(e.getStackTrace());
            throw new AccountServiceException();
        }
    }

    @Override
    public void updatePassword(int id, String oldPass, String newPass, String newPassCon) throws IllegalOldPasswordException, IllegalPasswordValidationException, AccountServiceException {
        Account a = getAccountById(id);
        if (!oldPass.equals(a.getPassword())) {
            throw new IllegalOldPasswordException();
        }
        Validator.passwordValidate(newPass, newPassCon);
        try {
            account.updatePassword(id, newPass);
        } catch (DAOAccountException e) {
            logger.error(e.getStackTrace());
            throw new AccountServiceException();
        }
    }

    @Override
    public void updateEmail(int id, String newEmail) throws IllegalEmailValidationException, AccountServiceException {
        Validator.emailValidate(newEmail, "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" );
        try {
            account.updateEmail(id, newEmail);
        } catch (DAOAccountException e) {
            logger.error(e.getStackTrace());
            throw new AccountServiceException();
        }
    }
}
