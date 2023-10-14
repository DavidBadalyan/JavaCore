package homework.medicalCenter.objects;

public class Patient extends Person {
    Doctor doctor;
    String regDate;

    public Patient(String id, String name, String surname, String phoneNumber, Doctor doctor, String regDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.doctor = doctor;
        this.regDate = regDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name=" + name +
                ", surname='" + surname + '\'' +
                ", id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", regDate='" + regDate + '\'' +
                ", doctor='" + doctor.toString() + '\'' +
                '}';
    }
}
