package homework.medicalCenter.exceptions;

public class DoctorByIDNotFoundException extends Exception {
    public DoctorByIDNotFoundException() {
    }

    public DoctorByIDNotFoundException(String message) {
        super(message);
    }

    public DoctorByIDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoctorByIDNotFoundException(Throwable cause) {
        super(cause);
    }

    public DoctorByIDNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
