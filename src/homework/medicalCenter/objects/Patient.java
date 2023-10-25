package homework.medicalCenter.objects;

import java.util.Date;

public class Patient extends Person {
    Doctor doctor;
    Date regDateTime;
    Date appDateTime;

    public Patient(String id, String name, String surname, String phoneNumber, Doctor doctor, Date regDateTime, Date appDateTime) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.doctor = doctor;
        this.regDateTime = regDateTime;
        this.appDateTime = appDateTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getRegDate() {
        return regDateTime;
    }

    public void setRegDate(Date regDate) {
        this.regDateTime = regDate;
    }

    public Date getAppDateTime() {
        return appDateTime;
    }

    public void setAppDateTime(Date appDateTime) {
        this.appDateTime = appDateTime;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name=" + name +
                ", surname='" + surname + '\'' +
                ", id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", regDate='" + regDateTime + '\'' +
                ", appointmentDateTime='" + appDateTime + '\'' +
                ", doctor='" + doctor.toString() + '\'' +
                '}';
    }
}
