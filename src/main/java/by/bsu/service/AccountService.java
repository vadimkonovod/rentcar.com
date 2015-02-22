package by.bsu.service;


import by.bsu.exception.service.AccountServiceException;
import by.bsu.exception.IllegalEmailValidationException;
import by.bsu.exception.IllegalOldPasswordException;
import by.bsu.exception.IllegalPasswordValidationException;
import by.bsu.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountService {
    public boolean checkLogin(String enterLogin, String enterPass) throws AccountServiceException;
    public void regAccount(String name, String surnname, String age, String email, String login, String password, String verpassword) throws IllegalEmailValidationException, IllegalOldPasswordException, SQLException, IllegalPasswordValidationException, AccountServiceException;
    public List<Account> getAccounts() throws AccountServiceException;
    public Account getAccountById(int id) throws AccountServiceException;
    public Account getAccountByLogin(String login) throws AccountServiceException;
    public void addAccount(Account a) throws SQLException, AccountServiceException;
    public void deleteAccount(int id) throws AccountServiceException;
    public void updatePassword(int id, String pass, String newPass, String newPassCon) throws IllegalOldPasswordException, IllegalPasswordValidationException, AccountServiceException;
    public void updateEmail(int id, String newEmail) throws IllegalEmailValidationException, AccountServiceException;
}
