package homework.employee;


import java.util.Scanner;

public class EmployeeStorage {
    private Employee[] employees = new Employee[10];
    private int size;

    public void add(Employee employee) {
        if (size == employees.length) {
            extend();
        }

        employees[size++] = employee;
    }

    private void extend() {
        Employee[] temp = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, temp, 0, employees.length);
        employees = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].getName() + " " + employees[i].getSurname() + " " + employees[i].getEmployeeID()
                    + " " + employees[i].getSalary() + " " + employees[i].getCompany() + " " + employees[i].getPosition());
        }
    }

    public void searchByID(String keyword) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().contains(keyword)) {
                System.out.println(employees[i].getName() + " " + employees[i].getSurname() + " " + employees[i].getEmployeeID()
                        + " " + employees[i].getSalary() + " " + employees[i].getCompany() + " " + employees[i].getPosition());
            }
        }
    }

    public void searchByCompany(String keyword) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().contains(keyword)) {
                System.out.println(employees[i].getName() + " " + employees[i].getSurname() + " " + employees[i].getEmployeeID()
                        + " " + employees[i].getSalary() + " " + employees[i].getCompany() + " " + employees[i].getPosition());
            }
        }
    }

    public void deleteByID(String employeeID) {
        int index = getByID(employeeID);
        if (index == -1) {
            System.out.println("There is no employee with an ID: " + employeeID);
            return;
        }
        for (int i = index; i < size-1; i++) {
            employees[i] = employees[i+1];
        }
        --size;
    }

    public void changeByID(String employeeID) {
        Scanner scanner = new Scanner(System.in);

        int index = getByID(employeeID);
        if (index == -1) {
            System.out.println("There is no employee with an ID: " + employeeID);
            return;
        }
        String name, surname, id, salary, company, position;
        System.out.print("Input a new name: ");
        name = scanner.nextLine();
        System.out.print("Input a new surname: ");
        surname = scanner.nextLine();
        System.out.print("Input a new ID: ");
        id = scanner.nextLine();
        System.out.print("Input a new salary: ");
        salary = scanner.nextLine();
        System.out.print("Input a new company: ");
        company = scanner.nextLine();
        System.out.print("Input a new position: ");
        position = scanner.nextLine();

        employees[index].setName(name);
        employees[index].setSurname(surname);
        employees[index].setEmployeeID(id);
        employees[index].setSalary(salary);
        employees[index].setCompany(company);
        employees[index].setPosition(position);

        System.out.println("Employee changed!");
    }

    public int getByID(String employeeID) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(employeeID)) {
                return i;
            }
        }
        return -1;
    }
}
