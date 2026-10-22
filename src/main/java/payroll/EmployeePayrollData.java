package payroll;

public class EmployeePayrollData {
    private final int id;
    private final String name;
    private final double salary;

    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id
                + ", Name: " + name
                + ", Salary: " + salary;
    }
}
