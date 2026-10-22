package payroll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PayrollFileServiceTest {

    @TempDir
    Path tempDir;

    private final PayrollFileService service = new PayrollFileService();

    private List<EmployeePayrollData> sampleEmployees() {
        return List.of(
                new EmployeePayrollData(1, "Jeff Bezos", 100000.0),
                new EmployeePayrollData(2, "Bill Gates", 200000.0),
                new EmployeePayrollData(3, "Mark Zuckerberg", 300000.0)
        );
    }

    @Test
    void shouldWritePayrollAndCountEntries() throws IOException {
        Path file = tempDir.resolve("payroll.txt");

        service.writePayroll(sampleEmployees(), file);

        assertEquals(3, service.countEntries(file));
    }

    @Test
    void shouldPrintPayrollLinesFromFile() throws IOException {
        Path file = tempDir.resolve("payroll.txt");
        service.writePayroll(sampleEmployees(), file);

        List<String> lines = service.printPayroll(file);

        assertEquals(3, lines.size());
        assertTrue(lines.get(0).contains("Jeff Bezos"));
    }

    @Test
    void shouldReadPayrollRecordsFromFile() throws IOException {
        Path file = tempDir.resolve("payroll.txt");
        service.writePayroll(sampleEmployees(), file);

        List<EmployeePayrollData> employees = service.readPayroll(file);

        assertEquals(3, employees.size());
        assertEquals("Bill Gates", employees.get(1).getName());
        assertEquals(200000.0, employees.get(1).getSalary());
    }
}
