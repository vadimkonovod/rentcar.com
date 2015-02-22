package by.bsu.exception.service;

public class AccountServiceException extends Exception {
    private Exception _hidden;

    public AccountServiceException() {
        super();
    }

    public AccountServiceException(String er) {
        super(er);
    }

    public AccountServiceException(String er, Exception e) {
        super(er);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }
}
