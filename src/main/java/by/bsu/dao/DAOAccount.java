package by.bsu.dao;

import by.bsu.exception.dao.DAOAccountException;
import by.bsu.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface DAOAccount {
    public List<Account> getAllAccounts() throws DAOAccountException;
    public Account getAccountById(int id) throws DAOAccountException;
    public Account getAccountByEmail(String email) throws DAOAccountException;
    public Account getAccountByLogin(String login) throws DAOAccountException;

    public void addAccount(Account account) throws SQLException, DAOAccountException;

    public void deleteAccountById(int id) throws DAOAccountException;

    public void updatePassword(int id, String pass) throws DAOAccountException;
    public void updateEmail(int id, String newEmail) throws DAOAccountException;

}
