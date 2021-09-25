package exceptions;

public class CustomNumberException extends Exception {
    public CustomNumberException(String message) {
        super(message);
    }

    public CustomNumberException(String message, Throwable e) {
        super(message, e);
    }
}
