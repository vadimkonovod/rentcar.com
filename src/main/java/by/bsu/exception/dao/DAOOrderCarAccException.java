package by.bsu.exception.dao;

public class DAOOrderCarAccException extends Exception {

    private Exception _hidden;

    public DAOOrderCarAccException() {
        super();
    }

    public DAOOrderCarAccException(String er) {
        super(er);
    }

    public DAOOrderCarAccException(String er, Exception e) {
        super(er);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }
}
