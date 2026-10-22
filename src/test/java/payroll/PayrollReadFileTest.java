package payroll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PayrollReadFileTest {

    @TempDir
    Path tempDir;

    private final PayrollFileService service = new PayrollFileService();

    @Test
    void shouldReadPayrollRecordsIntoEmployeeObjects() throws IOException {
        Path file = tempDir.resolve("payroll.txt");

        Files.write(file, List.of(
                "1,Jeff Bezos,100000.0",
                "2,Bill Gates,200000.0"
        ));

        List<EmployeePayrollData> employees = service.readPayroll(file);

        assertEquals(2, employees.size());
        assertEquals(1, employees.get(0).getId());
        assertEquals("Jeff Bezos", employees.get(0).getName());
        assertEquals(100000.0, employees.get(0).getSalary());
    }
}
