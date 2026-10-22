package payroll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PayrollFileService {

    public void writePayroll(
            List<EmployeePayrollData> employees,
            Path file) throws IOException {

        List<String> lines = new ArrayList<>();

        for (EmployeePayrollData employee : employees) {
            lines.add(employee.getId() + ","
                    + employee.getName() + ","
                    + employee.getSalary());
        }

        Files.write(file, lines);
    }

    public List<String> printPayroll(Path file) throws IOException {
        List<String> lines = Files.readAllLines(file);
        lines.forEach(System.out::println);
        return lines;
    }

    public long countEntries(Path file) throws IOException {
        try (var lines = Files.lines(file)) {
            return lines.count();
        }
    }

    public List<EmployeePayrollData> readPayroll(Path file)
            throws IOException {

        List<EmployeePayrollData> employees = new ArrayList<>();

        for (String line : Files.readAllLines(file)) {
            String[] fields = line.split(",", -1);

            employees.add(new EmployeePayrollData(
                    Integer.parseInt(fields[0]),
                    fields[1],
                    Double.parseDouble(fields[2])
            ));
        }

        return employees;
    }
}
