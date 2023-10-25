package homework.medicalCenter.exceptions;

public class DoctorIndexByIDNotFoundException extends Exception{
    public DoctorIndexByIDNotFoundException() {
    }

    public DoctorIndexByIDNotFoundException(String message) {
        super(message);
    }

    public DoctorIndexByIDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoctorIndexByIDNotFoundException(Throwable cause) {
        super(cause);
    }

    public DoctorIndexByIDNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
