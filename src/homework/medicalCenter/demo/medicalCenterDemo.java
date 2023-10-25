package homework.medicalCenter.demo;

import homework.medicalCenter.DateUtil;
import homework.medicalCenter.exceptions.DoctorByIDNotFoundException;
import homework.medicalCenter.exceptions.DoctorIndexByIDNotFoundException;
import homework.medicalCenter.exceptions.PatientByIDNotFoundException;
import homework.medicalCenter.objects.Doctor;
import homework.medicalCenter.objects.Patient;
import homework.medicalCenter.storages.DoctorStorage;
import homework.medicalCenter.storages.PatientStorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class medicalCenterDemo {
    private static Scanner scanner = new Scanner(System.in);
    private static PatientStorage patientStorage = new PatientStorage();
    private static DoctorStorage doctorStorage = new DoctorStorage();
    private static Date date = new Date();
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh/mm/ss");

    public static void main(String[] args) {
        boolean isActive = true;
        int choice;

        while (isActive) {
            printCommands();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0:
                    isActive = false;
                    break;
                case 1:
                    addDoctor();
                    break;
                case 2:
                    searchDocByProfession();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    changeDocByID();
                    break;
                case 5:
                    addPatient();
                    break;
                case 6:
                    printByDoc();
                    break;
                case 7:
                    printAllPatients();
                    break;
                default:
                    System.out.println("There is no command like that!");
                    break;
            }
        }
    }

    private static void addDoctor() {
        System.out.println("----------------------------------------------------------");
        System.out.print("Please input a name for the doctor: ");
        String name = scanner.nextLine();
        System.out.print("Please input a surname for the doctor: ");
        String surname = scanner.nextLine();
        System.out.print("Please input a ID for the doctor: ");
        String id = scanner.nextLine();
        try {
            doctorStorage.getIndexByID(id);
        }catch(DoctorIndexByIDNotFoundException e) {
            System.out.println("Error: There is already a doctor with such an ID!");
            return;
        }
        System.out.print("Please input a email for the doctor: ");
        String email = scanner.nextLine();
        System.out.print("Please input a phone number for the doctor: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Please input a profession for the doctor: ");
        String profession = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, surname, phoneNumber, email, profession);
        doctorStorage.add(doctor);

        System.out.println("Doctor added!");
        System.out.println("----------------------------------------------------------");
    }

    private static void searchDocByProfession() {
        System.out.println("----------------------------------------------------------");
        System.out.print("Please input a profession of a doctor: ");
        String givenProfession = scanner.nextLine();
        doctorStorage.searchDocByProfession(givenProfession);
        System.out.println("----------------------------------------------------------");
    }

    private static void changeDocByID() {
        System.out.println("----------------------------------------------------------");
        System.out.print("Please input the ID of the doctor you want to change: ");
        String givenID = scanner.nextLine();
        doctorStorage.changeDocByID(givenID);
        System.out.println("----------------------------------------------------------");
    }

    private static void addPatient() {
        System.out.println("----------------------------------------------------------");

        if (doctorStorage.isEmpty()) {
            System.out.println("Add at least one doctor first!");
            return;
        }

        System.out.print("Please input a name for the patient: ");
        String name = scanner.nextLine();
        System.out.print("Please input a surname for the patient: ");
        String surname = scanner.nextLine();
        System.out.print("Please input a ID for the patient: ");
        String id = scanner.nextLine();
        try{
            patientStorage.getIndexByID(id);
        } catch(PatientByIDNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Please input a phone number for the doctor: ");
        String phoneNumber = scanner.nextLine();
        System.out.println();
        System.out.println("Choose a doctor (enter the ID): ");
        doctorStorage.printDoctors();
        String givenID = scanner.nextLine();
        Doctor doctor;
        try{
            doctor = doctorStorage.getByID(givenID);
        } catch (DoctorByIDNotFoundException e){
            System.out.println("Doctor By ID Not Found");
            return;
        }

        String appointmentDateStr;
        Date appointmentDate;

        while(true) {
            appointmentDateStr = scanner.nextLine();
            try {
                appointmentDate = DateUtil.stringToDateTime(appointmentDateStr);
            } catch (ParseException exception) {
                System.out.println("Wrong date format! It should be dd/MM/yy hh:mm!! Try again.");
                continue;
            }
            break;
        }

        Patient patient = new Patient(id, name, surname, phoneNumber, doctor, new Date(), appointmentDate);
        if (patientStorage.isDateValid(doctor, appointmentDate)) {
            patientStorage.add(patient);
            System.out.println("Patient added!");
        }

        System.out.println("----------------------------------------------------------");
    }

    private static void printByDoc() {
        System.out.println("----------------------------------------------------------");
        System.out.print("Please input the id of the doctor whose patients you want to see: ");
        String docID = scanner.nextLine();
        System.out.print("Please input the phone number of the doctor whose patients you want to see: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Please input the email of the doctor whose patients you want to see: ");
        String email = scanner.nextLine();

        patientStorage.printPatientsByDoctor(docID, phoneNumber, email);
        System.out.println("----------------------------------------------------------");
    }

    private static void printAllPatients() {
        System.out.println("----------------------------------------------------------");
        patientStorage.printAllPatients();
        System.out.println("----------------------------------------------------------");
    }

    private static void printCommands() {
        System.out.println("Enter 0 - Exit");
        System.out.println("Enter 1 - Add Doctor");
        System.out.println("Enter 2 - Search Doctor by Profession");
        System.out.println("Enter 3 - Delete Doctor by ID");
        System.out.println("Enter 4 - Change Doctor by ID");
        System.out.println("Enter 5 - Add Patient");
        System.out.println("Enter 6 - Print All Patients of a Doctor");
        System.out.println("Enter 7 - Print All Patients");
    }

    private static void deleteDoctor() {
        System.out.println("----------------------------------------------------------");
        System.out.print("Please enter the ID of the doctor you want to remove: ");
        String givenID = scanner.nextLine();
        Doctor doctor;
        try{
            doctor = doctorStorage.getByID(givenID);
        } catch (DoctorByIDNotFoundException e){
            System.out.println("Doctor By ID Not Found");
            return;
        }
        patientStorage.deleteAllPatientsByDoctor(doctor);
        doctorStorage.deleteDocByID(givenID);

        System.out.println("Doctor and all his patients removed!");
        System.out.println("----------------------------------------------------------");
    }
}
