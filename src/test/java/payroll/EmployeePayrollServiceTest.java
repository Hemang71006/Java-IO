package payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollServiceTest {

    @Test
    void givenEmployeeDetails_whenCreated_thenDetailsAreStored() {
        EmployeePayrollData employee =
                new EmployeePayrollData(101, "Hemang", 45000.0);

        assertEquals(101, employee.getId());
        assertEquals("Hemang", employee.getName());
        assertEquals(45000.0, employee.getSalary());
    }

    @Test
    void givenEmployee_whenDisplayed_thenPayrollDetailsAreFormatted() {
        EmployeePayrollData employee =
                new EmployeePayrollData(101, "Hemang", 45000.0);

        assertEquals(
                "Employee ID: 101, Name: Hemang, Salary: 45000.0",
                employee.toString()
        );
    }
}
