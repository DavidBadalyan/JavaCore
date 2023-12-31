package homework.employee;

import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        boolean isActive = true;
        Scanner scanner = new Scanner(System.in);
        EmployeeStorage employeeStorage = new EmployeeStorage();

        while (isActive) {
            System.out.println("Input 0 in order to EXIT");
            System.out.println("Input 1 in order to ADD AN EMPLOYEE");
            System.out.println("Input 2 in order to PRINT ALL THE EMPLOYEES");
            System.out.println("Input 3 in order to SEARCH FOR AN EMPLOYEE WITH THE EMPLOYEE ID");
            System.out.println("Input 4 in order to SEARCH FOR AN EMPLOYEE WITH THE COMPANY NAME");
            System.out.println("Input 5 in order to DELETE EMPLOYEE BY ID");
            System.out.println("Input 6 in order to CHANGE EMPLOYEE INFO BY ID");

            String choice = scanner.nextLine();
            switch (choice) {
                case "0":
                    isActive = false;
                    break;
                case "1":
                    System.out.println("-----------------------------------");
                    System.out.print("Please input the name of the employee: ");
                    String name = scanner.nextLine();
                    System.out.print("Please input the surname of the employee: ");
                    String surname = scanner.nextLine();
                    System.out.print("Please enter the employee ID: ");
                    String employeeID = scanner.nextLine();
                    if (employeeStorage.getIndexByID(employeeID) != -1) {
                        System.out.println("Error: There is already an employee with such an ID");
                        continue;
                    }
                    System.out.print("Please input the salary of the employee: ");
                    String salary = scanner.nextLine();
                    System.out.print("Please input the company that the employee works at: ");
                    String company = scanner.nextLine();
                    System.out.print("Please input the position that the employee has: ");
                    String position = scanner.nextLine();

                    Employee employee = new Employee(name, surname, employeeID, salary, company, position);
                    employeeStorage.add(employee);
                    System.out.println("Employee signed!");
                    System.out.println("-----------------------------------");
                    break;
                case "2":
                    System.out.println("-----------------------------------");
                    employeeStorage.print();
                    System.out.println("-----------------------------------");
                    break;
                case "3":
                    System.out.println("-----------------------------------");
                    System.out.print("Please enter an ID: ");
                    String keywordID = scanner.nextLine();
                    employeeStorage.searchByID(keywordID);
                    System.out.println("-----------------------------------");
                case "4":
                    System.out.println("-----------------------------------");
                    System.out.print("Please enter an ID: ");
                    String keywordCompany = scanner.nextLine();
                    employeeStorage.searchByCompany(keywordCompany);
                    System.out.println("-----------------------------------");
                case "5":
                    System.out.println("-----------------------------------");
                    System.out.print("Please input the ID of the employee you want to remove: ");
                    String employeeIDInput = scanner.nextLine();
                    employeeStorage.deleteByID(employeeIDInput);
                    System.out.println("-----------------------------------");
                    break;
                case "6":
                    System.out.println("-----------------------------------");
                    System.out.print("Please input the ID of the employee you want to remove: ");
                    String employeeIDChange = scanner.nextLine();
                    employeeStorage.changeByID(employeeIDChange);
                    System.out.println("-----------------------------------");
                    break;
                default:
                    System.out.println("There is no command like that!");
                    break;
            }
        }
    }
}
