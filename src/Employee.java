import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    private final String middleName;
    private int department;
    private int salary;



    public Employee(String lastName, String firstName, String middleName, int department, int salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && middleName.equals(employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        if(department == 0) throw new IllegalArgumentException("Номер отдела не может быть меньше 1");
        this.department = department;
    }

    public void setSalary(int salary) {
        if(salary < 50_000) throw new IllegalArgumentException("Введите корректное значение зп");
        this.salary = salary;
    }


}
