package homework.medicalCenter.storages;

import homework.medicalCenter.exceptions.PatientByIDNotFoundException;
import homework.medicalCenter.objects.Doctor;
import homework.medicalCenter.objects.Patient;

import java.util.Calendar;
import java.util.Date;

public class PatientStorage {
    private Patient[] patients = new Patient[10];
    private int size;

    public void add(Patient patient) {
        if (size == patients.length) {
            extend();
        }

        patients[size++] = patient;
    }

    private void extend() {
        Patient[] temp = new Patient[patients.length + 10];
        System.arraycopy(patients, 0, temp, 0, patients.length);
        patients = temp;
    }

    public int getIndexByID(String patientID) throws PatientByIDNotFoundException{
        for (int i = 0; i < size; i++) {
            if (patients[i].getId().equals(patientID)) {
                return i;
            }
        }
        throw new PatientByIDNotFoundException("Patient with such an ID not found!");
    }

    public void printPatientsByDoctor(String docID, String docPhone, String docEmail) {
        Doctor doctor = new Doctor(docID, docPhone, docEmail);

        for (int i = 0; i < size; i++) {
            if (doctor.equals(patients[i].getDoctor())) {
                System.out.println(patients[i].toString());
            }
        }
    }

    public void printAllPatients() {
        for (int i = 0; i < size; i++) {
            System.out.println(patients[i].toString());
        }
    }

    public void deleteAllPatientsByDoctor(Doctor doctor) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getDoctor().equals(doctor)) {
                deletePatientByIndex(i);
            }
        }
    }

    public void deletePatientByIndex(int index) {
        for (int i = index; i < size - 1; i++) {
            patients[i] = patients[i + 1];
        }
        --size;
    }

    public boolean isDateValid(Doctor doctor, Date appointmentDateTime) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getDoctor().getId().equals(doctor.getId())) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(patients[i].getAppDateTime());
                calendar.add(Calendar.MINUTE, 29);
                Date appointmentDatePlus30Min = calendar.getTime();
                if(appointmentDateTime.after(appointmentDatePlus30Min)) {
                    return true;
                }
            }
        }
        return false;
    }
}