package by.bsu.exception.dao;

public class DAOCarException extends Exception {
    private Exception _hidden;

    public DAOCarException() {
        super();
    }

    public DAOCarException(String er) {
        super(er);
    }

    public DAOCarException(String er, Exception e) {
        super(er);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }
}
