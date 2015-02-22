package by.bsu.exception;


public class IllegalEmailValidationException extends Exception {

    private Exception _hidden;

    public IllegalEmailValidationException() {
        super();
    }

    public IllegalEmailValidationException(String er) {
        super(er);
    }

    public IllegalEmailValidationException(String er, Exception e) {
        super(er);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }
}
