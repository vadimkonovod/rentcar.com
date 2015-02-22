package by.bsu.exception;


public class IllegalPasswordValidationException extends Exception {

    private Exception _hidden;

    public IllegalPasswordValidationException() {
        super();
    }

    public IllegalPasswordValidationException(String er) {
        super(er);
    }

    public IllegalPasswordValidationException(String er, Exception e) {
        super(er);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }
}
