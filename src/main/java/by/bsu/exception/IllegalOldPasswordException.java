package by.bsu.exception;


public class IllegalOldPasswordException extends Exception {

    private Exception _hidden;

    public IllegalOldPasswordException() {
        super();
    }

    public IllegalOldPasswordException(String er) {
        super(er);
    }

    public IllegalOldPasswordException(String er, Exception e) {
        super(er);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }
}
