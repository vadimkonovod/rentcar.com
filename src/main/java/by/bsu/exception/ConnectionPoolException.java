package by.bsu.exception;

public class ConnectionPoolException extends Exception{
    private Exception _hidden;

    public ConnectionPoolException() {
        super();
    }

    public ConnectionPoolException(String er) {
        super(er);
    }

    public ConnectionPoolException(String er, Exception e) {
        super(er);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }
}
