package payroll;

import java.util.Scanner;

public class EmployeePayrollService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        EmployeePayrollData employee =
                new EmployeePayrollData(id, name, salary);

        System.out.println("\nEmployee Payroll Details");
        System.out.println(employee);

        scanner.close();
    }
}
