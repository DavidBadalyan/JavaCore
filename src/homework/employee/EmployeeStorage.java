package homework.employee;


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
}
