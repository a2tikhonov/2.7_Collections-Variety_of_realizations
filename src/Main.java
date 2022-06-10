public class Main {
    public static void main(String[] args) {
        Employee ivanov = new Employee("Иванов", "Иван", "Иванович", 1, 150_150);
        Employee petrov = new Employee("Петров", "Петр", "Петрович", 2, 200_000);
        Employee alekdsandrov = new Employee("Александров", "Александр", "Александрович", 2, 300_000);
        Employee alekdsandrov2 = new Employee("Александров2", "Александр2", "Александрович2", 2, 360_000);
        Employee alekdsandrov3 = new Employee("Александров3", "Александр3", "Александрович3", 2, 340_000);
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.add(ivanov);
        employeeBook.add(alekdsandrov2);
        employeeBook.add(alekdsandrov3);
        employeeBook.add(petrov);
        employeeBook.add(alekdsandrov);
        employeeBook.print();
        System.out.println("Сумма затрат на зарплаты в месяц " + employeeBook.formatSalary(employeeBook.calculateSalaryCosts()) + " р.");
        System.out.println("Cотрудник с минимальной зарплатой " + employeeBook.employeeWithMinSalary());
        System.out.println("Cотрудник с максимальной зарплатой " + employeeBook.employeeWithMaxSalary());
        System.out.println("Среднее значение зарплат " + employeeBook.formatSalary((int) employeeBook.calculateSalariesAverage()) + " р.");
        employeeBook.raiseAllEmployees(20);
        employeeBook.print();
        System.out.println("Cотрудник с минимальной зарплатой 2-го отдела " + employeeBook.employeeWithMinSalary(2));
        System.out.println("Cотрудник с максимальной зарплатой 2-го отдела " + employeeBook.employeeWithMaxSalary(2));
        System.out.println("Средняя зарплата по отделу " + employeeBook.formatSalary((int) employeeBook.calculateSalariesAverage(2)) + " р.");
        employeeBook.printWithSalaryLessThan(350_000);
        employeeBook.printWithSalaryMoreOrEquals(288_000);
        employeeBook.printDepartment(2);
    }
}