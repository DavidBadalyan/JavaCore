package homework.medicalCenter.storages;


import homework.medicalCenter.exceptions.DoctorByIDNotFoundException;
import homework.medicalCenter.exceptions.DoctorIndexByIDNotFoundException;
import homework.medicalCenter.objects.Doctor;

import java.util.Scanner;

public class DoctorStorage {
    private Doctor[] doctors = new Doctor[10];
    private int size;

    public void add(Doctor doctor) {
        if (size == doctors.length) {
            extend();
        }

        doctors[size++] = doctor;
    }

    private void extend() {
        Doctor[] temp = new Doctor[doctors.length + 10];
        System.arraycopy(doctors, 0, temp, 0, doctors.length);
        doctors = temp;
    }

    public int getIndexByID(String doctorID) throws DoctorIndexByIDNotFoundException{
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(doctorID)) {
                return i;
            }
        }
        throw new DoctorIndexByIDNotFoundException("Doctor Index By ID Not Found");
    }

    public Doctor getByID(String doctorID) throws DoctorByIDNotFoundException{
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(doctorID)) {
                return doctors[i];
            }
        }
        throw new DoctorByIDNotFoundException("Doctor By ID Not Found");
    }

    public void searchDocByProfession(String givenProfession) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getProfession().equals(givenProfession)) {
                System.out.println(doctors[i].toString());
            }
        }
    }

    public void changeDocByID(String givenID) {
        int index;
        try {
            index = getIndexByID(givenID);
        } catch (DoctorIndexByIDNotFoundException e) {
            System.out.println("Doctor Index By ID Not Found");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input a new name for the doctor: ");
        String newName = scanner.nextLine();
        System.out.print("Please input a new surname for the doctor: ");
        String newSurname = scanner.nextLine();
        System.out.print("Please input a new email for the doctor: ");
        String newMail = scanner.nextLine();
        System.out.print("Please input a new phone number for the doctor: ");
        String newNumber = scanner.nextLine();
        System.out.print("Please input a new profession for the doctor: ");
        String newProfession = scanner.nextLine();

        doctors[index].setName(newName);
        doctors[index].setSurname(newSurname);
        doctors[index].setEmail(newMail);
        doctors[index].setPhoneNumber(newNumber);
        doctors[index].setProfession(newProfession);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void deleteDocByID(String givenID) {
        int index;
        try{
            index = getIndexByID(givenID);
        } catch (DoctorIndexByIDNotFoundException e) {
            System.out.println("Doctor Index By ID Not Found");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            doctors[i] = doctors[i + 1];
        }
        --size;
    }

    public void printDoctors() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i].toString());
        }
    }


}
