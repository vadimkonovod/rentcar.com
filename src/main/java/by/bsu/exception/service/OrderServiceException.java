package by.bsu.exception.service;

public class OrderServiceException extends Exception {
    private Exception _hidden;

    public OrderServiceException() {
        super();
    }

    public OrderServiceException(String er) {
        super(er);
    }

    public OrderServiceException(String er, Exception e) {
        super(er);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }
}
