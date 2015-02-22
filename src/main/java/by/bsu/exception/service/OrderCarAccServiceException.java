package by.bsu.exception.service;

public class OrderCarAccServiceException extends Exception {
    private Exception _hidden;

    public OrderCarAccServiceException() {
        super();
    }

    public OrderCarAccServiceException(String er) {
        super(er);
    }

    public OrderCarAccServiceException(String er, Exception e) {
        super(er);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }
}
