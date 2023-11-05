package homework.onlineStore.Exception;

public class NoSuchOrderException extends Exception {
    public NoSuchOrderException() {
    }

    public NoSuchOrderException(String message) {
        super(message);
    }

    public NoSuchOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchOrderException(Throwable cause) {
        super(cause);
    }

    public NoSuchOrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
