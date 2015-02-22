package by.bsu.exception.dao;

public class DAOOrderException extends Exception {

    private Exception _hidden;

    public DAOOrderException() {
        super();
    }

    public DAOOrderException(String er) {
        super(er);
    }

    public DAOOrderException(String er, Exception e) {
        super(er);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }
}
