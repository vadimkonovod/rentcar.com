package by.bsu.dao.mysql;

import by.bsu.dao.DAOAccount;
import by.bsu.db.ConnectionPool;
import by.bsu.exception.ConnectionPoolException;
import by.bsu.exception.dao.DAOAccountException;
import by.bsu.model.Account;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAOAccount implements DAOAccount {
    private final static Logger logger = Logger.getLogger(MySQLDAOAccount.class);

    private static final String GET_ALL_ACCOUNTS = "SELECT * FROM account";
    private static final String GET_ACCOUNT_BY_ID = "SELECT * FROM account WHERE accountID=?";
    private static final String GET_ACCOUNT_BY_EMAIL = "SELECT * FROM account WHERE email=?";
    private static final String GET_ACCOUNT_BY_LOGIN = "SELECT * FROM account WHERE login=?";

    private static final String INSERT_NEW_ACCOUNT = "INSERT INTO account(name, surname, age, email, login, password) VALUES(?,?,?,?,?,?)";

    private static final String DELETE_ACCOUNT_BY_ID = "DELETE FROM account WHERE accountID=?";

    private static final String UPDATE_PASSWORD = "UPDATE account SET password=? WHERE accountID = ?";
    private static final String UPDATE_EMAIL = "UPDATE account SET email=? WHERE accountID = ?";


    PreparedStatement preparedStatement;

    private static MySQLDAOAccount ourInstance = new MySQLDAOAccount();

    public static MySQLDAOAccount getInstance() {
        return ourInstance;
    }

    @Override
    public List<Account> getAllAccounts() throws DAOAccountException {
        List<Account> accounts = null;
        try {
            accounts = new ArrayList<Account>();
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(GET_ALL_ACCOUNTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Account account = new Account();
                account.setId(resultSet.getInt("accountID"));
                account.setName(resultSet.getString("name"));
                account.setSurname(resultSet.getString("surname"));
                account.setAge(resultSet.getInt("age"));
                account.setEmail(resultSet.getString("email"));
                account.setLogin(resultSet.getString("login"));
                account.setPassword(resultSet.getString("password"));
                account.setRole(resultSet.getString("role"));
                accounts.add(account);
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOAccountException();
        }
        return accounts;
    }

    @Override
    public Account getAccountById(int id) throws DAOAccountException {
        Account account = new Account();
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(GET_ACCOUNT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                account.setId(resultSet.getInt("accountID"));
                account.setName(resultSet.getString("name"));
                account.setSurname(resultSet.getString("surname"));
                account.setAge(resultSet.getInt("age"));
                account.setEmail(resultSet.getString("email"));
                account.setLogin(resultSet.getString("login"));
                account.setPassword(resultSet.getString("password"));
                account.setRole(resultSet.getString("role"));
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOAccountException();
        }
        return account;
    }

    @Override
    public Account getAccountByEmail(String email) throws DAOAccountException {
        Account account = new Account();
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(GET_ACCOUNT_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                account.setId(resultSet.getInt("accountID"));
                account.setName(resultSet.getString("name"));
                account.setSurname(resultSet.getString("surname"));
                account.setAge(resultSet.getInt("age"));
                account.setEmail(resultSet.getString("email"));
                account.setLogin(resultSet.getString("login"));
                account.setPassword(resultSet.getString("password"));
                account.setRole(resultSet.getString("role"));
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOAccountException();
        }
        return account;
    }

    @Override
    public Account getAccountByLogin(String login) throws DAOAccountException {
        Account account = null;
        try {
            Connection connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                account = new Account();
                account.setId(resultSet.getInt("accountID"));
                account.setName(resultSet.getString("name"));
                account.setSurname(resultSet.getString("surname"));
                account.setAge(resultSet.getInt("age"));
                account.setEmail(resultSet.getString("email"));
                account.setLogin(resultSet.getString("login"));
                account.setPassword(resultSet.getString("password"));
                account.setRole(resultSet.getString("role"));
            }
            ConnectionPool.getInstance().closeConnection(connection, preparedStatement, resultSet);
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOAccountException();
        }
        return account;
    }

    @Override
    public void addAccount(Account account) throws SQLException, DAOAccountException {
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(INSERT_NEW_ACCOUNT);
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getSurname());
            preparedStatement.setInt(3, account.getAge());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setString(5, account.getLogin());
            preparedStatement.setString(6, account.getPassword());
            preparedStatement.execute();
        } catch (ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOAccountException();
        }
    }

    @Override
    public void deleteAccountById(int id) throws DAOAccountException {
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(DELETE_ACCOUNT_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOAccountException();
        }
    }

    @Override
    public void updatePassword(int id, String pass) throws DAOAccountException {
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(UPDATE_PASSWORD);
            preparedStatement.setString(1, pass);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOAccountException();
        }
    }

    @Override
    public void updateEmail(int id, String newEmail) throws DAOAccountException {
        try {
            preparedStatement = ConnectionPool.getInstance().takeConnection().prepareStatement(UPDATE_EMAIL);
            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error(e.getStackTrace());
            throw new DAOAccountException();
        }
    }
}
