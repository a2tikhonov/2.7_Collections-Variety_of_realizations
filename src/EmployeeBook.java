import java.lang.reflect.Array;
import java.security.spec.RSAOtherPrimeInfo;
import java.text.DecimalFormat;
import java.util.*;

public class EmployeeBook {
    private final Map<String, Employee> employees;


    EmployeeBook() {
        this.employees = new HashMap<>();
    }

    public void add(String lastName, String firstName, String middleName, int department, int salary) {
        Employee employee = new Employee(lastName, firstName, middleName, department, salary);
        String key = lastName + firstName + middleName;
        if (!employees.containsKey(key)) {
            employees.put(key, employee);
        } else {
            System.out.println("Такой сотрудник уже есть в базе");
        }
    }

    public void add(Employee employee) {
        String key = employee.getLastName() + employee.getFirstName() + employee.getMiddleName();
        if (!employees.containsKey(key)) {
            employees.put(key, employee);
        } else {
            System.out.println("Такой сотрудник уже есть в базе");
        }
    }

    public void remove(String lastName, String firstName, String middleName) {
        String key = lastName + firstName + middleName;
        if (employees.remove(key) == null) {
            System.out.println("Такого сотрудника нет в базе");
        }
    }

    public void remove(Employee employee) {
        String key = employee.getLastName() + employee.getFirstName() + employee.getMiddleName();
        if (employees.remove(key) == null) {
            System.out.println("Такого сотрудника нет в базе");
        }
    }

    public void changeSalary(String lastName, String firstName, String middleName, int salary) {
        String key = lastName + firstName + middleName;
        Employee employee = employees.get(key);
        if (employee != null) {
            employee.setSalary(salary);
            employees.replace(key, employee);
        } else {
            System.out.println("Такого сотрудника нет в базе");
        }

    }

    public void changeDepartment(String lastName, String firstName, String middleName, int department) {
        String key = lastName + firstName + middleName;
        Employee employee = employees.get(key);
        if (employee != null) {
            employee.setDepartment(department);
            employees.replace(key, employee);
        } else {
            System.out.println("Такого сотрудника нет в базе");
        }
    }

    public int calculateSalaryCosts() {
        int sumOfSalaries = 0;
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            sumOfSalaries += employee.getValue().getSalary();
        }
        return sumOfSalaries;
    }

    public int calculateSalaryCosts(int department) {
        int sumOfSalaries = 0;
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (employee.getValue().getDepartment() == department) {
                sumOfSalaries += employee.getValue().getSalary();
            }
        }
        return sumOfSalaries;
    }

    public String employeeWithMinSalary() {
        if (employees.isEmpty()) {
            return "Книга учета сотрудников пуста";
        }
        Integer minimumSalary = Integer.MAX_VALUE;
        String employeeName = null;
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (minimumSalary > employee.getValue().getSalary()) {
                minimumSalary = employee.getValue().getSalary();
                employeeName = employee.getValue().toString();
            }
        }
        return employeeName;
    }

    public String employeeWithMinSalary(int department) {
        if (employees.isEmpty()) {
            return "Книга учета сотрудников пуста";
        }
        Integer minimumSalary = Integer.MAX_VALUE;
        String employeeName = null;
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (department == employee.getValue().getDepartment() &&
                    minimumSalary > employee.getValue().getSalary()) {
                minimumSalary = employee.getValue().getSalary();
                employeeName = employee.getValue().toString();
            }
        }
        return employeeName;
    }

    public String employeeWithMaxSalary() {
        if (employees.isEmpty()) {
            return "Книга учета сотрудников пуста";
        }
        Integer maximumSalary = 0;
        String employeeName = null;
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (maximumSalary < employee.getValue().getSalary()) {
                maximumSalary = employee.getValue().getSalary();
                employeeName = employee.getValue().toString();
            }
        }
        return employeeName;
    }

    public String employeeWithMaxSalary(int department) {
        if (employees.isEmpty()) {
            return "Книга учета сотрудников пуста";
        }
        Integer maximumSalary = 0;
        String employeeName = null;
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (department == employee.getValue().getDepartment() &&
                    maximumSalary < employee.getValue().getSalary()) {
                maximumSalary = employee.getValue().getSalary();
                employeeName = employee.getValue().toString();
            }
        }
        return employeeName;
    }

    public float calculateSalariesAverage() {
        return (float) calculateSalaryCosts() / employees.size();
    }

    public float calculateSalariesAverage(int department) {
        int sumOfSalaries = 0;
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (department == employee.getValue().getDepartment()) {
                sumOfSalaries += employee.getValue().getSalary();
            }
        }
        return (float) sumOfSalaries / employees.size();
    }

    public void raiseAllEmployees(int percentage) {
        Employee employeeToRise;
        float indexation = (float) percentage / 100;
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            employeeToRise = employee.getValue();
            employeeToRise.setSalary(employeeToRise.getSalary() + (int) (employeeToRise.getSalary() * indexation));
            employee.setValue(employeeToRise);
        }
    }

    public void raiseAllEmployees(int department, int percentage) {
        Employee employeeToRise;
        float indexation = (float) percentage / 100;
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (department == employee.getValue().getDepartment()) {
                employeeToRise = employee.getValue();
                employeeToRise.setSalary(employeeToRise.getSalary() + (int) (employeeToRise.getSalary() * indexation));
                employee.setValue(employeeToRise);
            }
        }
    }

    private void printDelimiter() {
        System.out.println("############################");
    }

    public String formatSalary(int salary) {
        return new DecimalFormat("###,###").format(salary);
    }

    public void printDepartment(int department) {
        printDelimiter();
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (department == employee.getValue().getDepartment()) {
                System.out.println(employee.getValue().toString() + " " +
                        formatSalary(employee.getValue().getSalary()));
            }
        }
        printDelimiter();
    }

    public void printWithSalaryLessThan(int salary) {
        printDelimiter();
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (salary > employee.getValue().getSalary()) {
                System.out.println(employee.getValue().toString() + " " +
                        formatSalary(employee.getValue().getSalary()));
            }
        }
        printDelimiter();
    }

    public void printWithSalaryMoreOrEquals(int salary) {
        printDelimiter();
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            if (salary <= employee.getValue().getSalary()) {
                System.out.println(employee.getValue().toString() + " " +
                        formatSalary(employee.getValue().getSalary()));
            }
        }
        printDelimiter();
    }

    public void print() {
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            System.out.println(employee.getValue().toString() + " " +
                    formatSalary(employee.getValue().getSalary()));
        }
    }

    public void printByDepartments() {
        Set<Integer> departments = new HashSet<>();
        for (Map.Entry<String, Employee> employee : employees.entrySet()) {
            departments.add(employee.getValue().getDepartment());
        }
        List<Integer> arr = new ArrayList<>();
        arr.addAll(departments);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("Отдел № " + arr.get(i));
            print();
            printDelimiter();
        }
    }
}
