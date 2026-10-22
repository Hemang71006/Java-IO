package payroll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PayrollPrintCountTest {

    @TempDir
    Path tempDir;

    private final PayrollFileService service = new PayrollFileService();

    @Test
    void shouldPrintPayrollFileLines() throws IOException {
        Path file = tempDir.resolve("payroll.txt");

        Files.write(file, List.of(
                "1,Jeff Bezos,100000.0",
                "2,Bill Gates,200000.0"
        ));

        List<String> printedLines = service.printPayroll(file);

        assertEquals(2, printedLines.size());
        assertEquals("1,Jeff Bezos,100000.0", printedLines.get(0));
    }

    @Test
    void shouldCountPayrollFileEntries() throws IOException {
        Path file = tempDir.resolve("payroll.txt");

        Files.write(file, List.of(
                "1,Jeff Bezos,100000.0",
                "2,Bill Gates,200000.0",
                "3,Mark Zuckerberg,300000.0"
        ));

        assertEquals(3, service.countEntries(file));
    }
}