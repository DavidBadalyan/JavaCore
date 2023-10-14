package homework.medicalCenter.objects;

import java.util.Objects;

public class Doctor extends Person {
    String email;
    String profession;

    public Doctor(String id, String phoneNumber, String email) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Doctor(String id, String name, String surname, String phoneNumber, String email, String profession) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.profession = profession;
    }

    public Doctor() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        return Objects.equals(this.getId(), doctor.getId()) && Objects.equals(this.getEmail(), doctor.getEmail()) && Objects.equals(this.getPhoneNumber(), doctor.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "email='" + email + '\'' +
                ", profession='" + profession + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
