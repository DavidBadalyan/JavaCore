package homework.onlineStore.Exception;

public class NoSuchProductException extends Exception {
    public NoSuchProductException() {
    }

    public NoSuchProductException(String message) {
        super(message);
    }

    public NoSuchProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchProductException(Throwable cause) {
        super(cause);
    }

    public NoSuchProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
