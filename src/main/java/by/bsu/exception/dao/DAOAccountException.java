package by.bsu.exception.dao;

public class DAOAccountException extends Exception {
    private Exception _hidden;

    public DAOAccountException() {
        super();
    }

    public DAOAccountException(String er) {
        super(er);
    }

    public DAOAccountException(String er, Exception e) {
        super(er);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }
}
