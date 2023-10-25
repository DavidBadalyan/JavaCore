package homework.medicalCenter.exceptions;

public class PatientByIDNotFoundException extends Exception{
    public PatientByIDNotFoundException() {
    }

    public PatientByIDNotFoundException(String message) {
        super(message);
    }

    public PatientByIDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PatientByIDNotFoundException(Throwable cause) {
        super(cause);
    }

    public PatientByIDNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
