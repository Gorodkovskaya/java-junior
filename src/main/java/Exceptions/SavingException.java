package Exceptions;

public class SavingException extends RuntimeException {
    public SavingException() {
        super();
    }

    public SavingException(String message) {
        super(message);
    }

    public SavingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SavingException(Throwable cause) {
        super(cause);
    }

    protected SavingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
