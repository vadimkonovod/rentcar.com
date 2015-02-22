package by.bsu.exception.service;

public class CarServiceException extends Exception {
    private Exception _hidden;

    public CarServiceException() {
        super();
    }

    public CarServiceException(String er) {
        super(er);
    }

    public CarServiceException(String er, Exception e) {
        super(er);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }
}
